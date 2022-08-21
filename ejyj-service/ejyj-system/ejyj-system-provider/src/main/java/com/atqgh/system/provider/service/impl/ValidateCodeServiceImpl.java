package com.atqgh.system.provider.service.impl;

import com.atqgh.common.core.constants.CommonConstants;
import com.atqgh.common.core.exception.MicroException;
import com.atqgh.common.core.utils.RedisUtils;
import com.atqgh.system.provider.config.SystemProperties;
import com.atqgh.system.provider.config.ValidateCodeProperties;
import com.atqgh.system.provider.service.ValidateCodeService;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

/**
 * 验证码.
 *
 * @author Mubai
 * @since 2022/8/21 10:42 上午
 **/
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {

    @Resource
    private SystemProperties properties;

    @Override
    public void create(@NonNull String key, HttpServletResponse response) throws IOException {

        ValidateCodeProperties code = properties.getCode();
        setHeader(response, code.getType());

        Captcha captcha = createCaptcha(code);
        RedisUtils.set(CommonConstants.System.CODE_PREFIX + key, StringUtils.lowerCase(captcha.text()), code.getTime());
        captcha.out(response.getOutputStream());
    }

    @Override
    public void check(@NonNull String key, @NonNull String value) {

        Object codeInRedis = RedisUtils.get(CommonConstants.System.CODE_PREFIX + key);
        if (!StringUtils.equalsIgnoreCase(value, String.valueOf(codeInRedis))) {
            throw new MicroException("验证码不正确");
        }
    }

    private Captcha createCaptcha(ValidateCodeProperties code) {

        Captcha captcha;
        if (StringUtils.equalsIgnoreCase(code.getType(), CommonConstants.System.GIF)) {
            captcha = new GifCaptcha(code.getWidth(), code.getHeight(), code.getLength());
        } else {
            captcha = new SpecCaptcha(code.getWidth(), code.getHeight(), code.getLength());
        }
        captcha.setCharType(code.getCharType());
        return captcha;
    }

    private void setHeader(HttpServletResponse response, String type) {

        if (StringUtils.equalsIgnoreCase(type, CommonConstants.System.GIF)) {
            response.setContentType(MediaType.IMAGE_GIF_VALUE);
        } else {
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
        }
        response.setHeader(HttpHeaders.PRAGMA, "No-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, 0L);
    }

}
