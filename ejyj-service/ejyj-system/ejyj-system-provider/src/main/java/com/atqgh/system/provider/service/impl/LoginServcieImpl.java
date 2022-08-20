package com.atqgh.system.provider.service.impl;

import com.atqgh.common.constants.RedisConstants;
import com.atqgh.common.security.domain.LoginUserDetailDto;
import com.atqgh.common.security.utils.JwtUtil;
import com.atqgh.common.security.utils.RedisCache;
import com.atqgh.common.utils.JsonUtils;
import com.atqgh.system.provider.service.LoginServcie;
import com.atqgh.system.provider.vo.LoginUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * 登录接口.
 * @author Mubai
 * @date 2022/7/9 9:46 下午
 **/
@Service
public class LoginServcieImpl implements LoginServcie {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public String login(LoginUserVo loginUserVo) {

        // 1，获取AuthenticationManager
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUserVo.getUserName(), loginUserVo.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 如果没有认证通过，则报异常
        if (ObjectUtils.isEmpty(authenticate)) {
            throw new RuntimeException("登陆失败");
        }

        // 如果认证通过了，则使用jwt生成一个jwt，返回
        LoginUserDetailDto loginUser = (LoginUserDetailDto) authenticate.getPrincipal();
        String loginUserContent = JsonUtils.toString(loginUser.getLoginSysUserDto());
        // 把完整对象存入redis中
        String jwt = JwtUtil.createJWT(loginUserContent);
        redisCache.setCacheObject(RedisConstants.LOGINKEY + loginUser.getLoginSysUserDto().getUserId(), loginUser);

        // 查询对应的权限信息
        return jwt;
    }

    @Override
    public void logout() {

        // 获取SecurityContextHolder中的id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUserDetailDto loginUser = (LoginUserDetailDto) authentication.getPrincipal();
        Long userId = loginUser.getLoginSysUserDto().getUserId();

        this.redisCache.deleteObject(RedisConstants.LOGINKEY + userId);
    }
}
