package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.LoginUserVo;

/**
 * 用户信息.
 * @author Mubai
 * @date 2022/7/11 9:38 下午
 **/
public interface LoginServcie {

    /**
     * 登陆.
     * @param loginUserVo 登陆用户
     * @return 结果
     */
    String login(LoginUserVo loginUserVo);

    /**
     * 退出登陆的方法.
     */
    void logout();

}
