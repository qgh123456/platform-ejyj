package com.atqgh.system.provider.service;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.NonNull;

/**
 * 验证码.
 *
 * @author Mubai
 * @since 2022/8/21 10:38 上午
 **/
public interface ValidateCodeService {

    /**
     * 创建验证码.
     * @param key 请求
     * @param response 相应
     * @throws IOException 异常
     */
    void create(@NonNull String key, HttpServletResponse response) throws IOException;

    /**
     * 检查验证码.
     * @param key key
     * @param value value
     */
    void check(String key, String value);


}
