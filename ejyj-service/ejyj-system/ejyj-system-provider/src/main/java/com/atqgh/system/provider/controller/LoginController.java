package com.atqgh.system.provider.controller;

import com.atqgh.common.core.domain.ResultObj;
import com.atqgh.system.provider.service.LoginServcie;
import com.atqgh.system.provider.vo.LoginUserVo;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class LoginController {

    @Resource
    private LoginServcie loginServcie;

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

}
