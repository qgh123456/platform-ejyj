package com.atqgh.common.security.filter;

import com.atqgh.common.constants.RedisConstants;
import com.atqgh.common.enums.AuthEnum;
import com.atqgh.common.exception.MicroAuthException;
import com.atqgh.common.security.domain.LoginUserDetailDto;
import com.atqgh.common.security.utils.JwtUtil;
import com.atqgh.common.security.utils.RedisCache;
import io.jsonwebtoken.Claims;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 这里实现的是OncePerRequestFilter，因为在不同的servlet中其他的可能会调用多次.
 *
 * @author Mubai
 * @date 2022/7/10 10:09 上午
 **/
@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 获取token
        String token = request.getHeader(RedisConstants.TOKENHEADER);
        if (!StringUtils.hasText(token)) {
            // 放行,因为后面还有FilterSecurityInterceptor过滤器，这个过滤器会判断当前的状态
            filterChain.doFilter(request, response);
            return;
        }
        // 解析token
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new MicroAuthException(AuthEnum.AUTH_NO_TOKEN.getCode(), "token非法");
        }
        // 从redis中获取用户信息
        String redisKey = RedisConstants.LOGINKEY + userid;
        LoginUserDetailDto loginUser = redisCache.getCacheObject(redisKey);
        if (ObjectUtils.isEmpty(loginUser)) {
            throw new MicroAuthException(AuthEnum.AUTH_NO_TOKEN.getCode(), "用户未登录");
        }
        // 存入SecurityContextHolder
        //  获取权限信息封装到Authentication中

        // 这里构造函数使用三个参数的构造，因为这里面会设置认证状态为true
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

    }
}
