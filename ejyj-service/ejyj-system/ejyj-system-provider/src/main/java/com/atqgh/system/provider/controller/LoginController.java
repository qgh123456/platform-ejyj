package com.atqgh.system.provider.controller;//package com.atqgh.system.provider.controller;
//
//import com.atqgh.common.domain.ResultObj;
//import javax.annotation.Resource;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 用于登录.
// *
// * @author Mubai
// * @date 2022/7/10 8:50 下午
// **/
//@RestController
//public class LoginController {
//
//    @Resource
//    private LoginServcie loginServcie;
//
//    /**
//     * 登录.
//     * @param sysUser 用户
//     * @return 结果
//     */
//    @PostMapping("/user/login")
//    public ResultObj login(@RequestBody SysUser sysUser) {
//        return this.loginServcie.login(sysUser);
//    }
//
//    /**
//     * 退出登录.
//     * @return 结果
//     */
//    @GetMapping("/user/logout")
//    public ResultObj logout() {
//        return this.loginServcie.logout();
//    }
//}
