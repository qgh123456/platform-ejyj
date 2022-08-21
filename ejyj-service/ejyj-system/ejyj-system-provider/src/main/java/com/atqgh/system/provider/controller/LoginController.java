package com.atqgh.system.provider.controller;

import com.atqgh.common.core.domain.ResultObj;
import com.atqgh.system.provider.service.LoginServcie;
import com.atqgh.system.provider.service.ValidateCodeService;
import com.atqgh.system.provider.vo.LoginUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于登录.
 *
 * @author Mubai
 * @date 2022/7/10 8:50 下午
 **/
@RestController
@RequestMapping("/system")
@Slf4j
@Api(tags = "登陆/退出登陆")
public class LoginController {

    @Resource
    private LoginServcie loginServcie;

    @Resource
    private ValidateCodeService validateCodeService;

    /**
     * 登录.
     * @param sysUserVo 用户
     * @return 结果
     */
    @PostMapping("/login")
    public ResultObj<String> login(@RequestBody LoginUserVo sysUserVo) {

        return ResultObj.success(this.loginServcie.login(sysUserVo));
    }

    /**
     * 退出登录.
     * @return 结果
     */
    @GetMapping("/logout")
    public ResultObj<String> logout() {

        this.loginServcie.logout();
        return ResultObj.success("退出登录成功");
    }

    /**
     * 获取验证码.
     * @param key 请求
     * @param response 响应
     * @throws IOException 异常
     */
    @GetMapping("/captcha")
    public void captcha(@ApiParam("key") @RequestParam("key") String key, HttpServletResponse response) throws IOException {
        validateCodeService.create(key, response);
    }

}
