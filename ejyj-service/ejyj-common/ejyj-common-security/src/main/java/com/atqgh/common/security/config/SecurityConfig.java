package com.atqgh.common.security.config;

import com.atqgh.common.security.filter.JwtAuthenticationTokenFilter;
import javax.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 权限配置.
 * @author Mubai
 * @date 2022/7/9 7:59 下午
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    private AccessDeniedHandler accessDeniedHandler;

    /**
     * 密码加密器.
     * @return 密码
     */
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }

    /**
     * 权限管理器.
     * @return 权限管理器
     * @throws Exception 异常
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String loginUrl = "/system/login";
        http
            // 关闭csrf，前后端分离的项目相当于自带csrf防护
            .csrf().disable()
            // 不通过Session获取SecurityContext
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            // 对于登录接口 允许匿名访问（没有登陆的情况下可以访问这个路径,登陆之后是访问不了的）
            // permitAll() 所有的都可以访问
            .antMatchers(loginUrl).anonymous()
            // 除上面外的所有请求全部需要鉴权认证
            .anyRequest().authenticated();

        // 在用户名密码过滤器之前（这里实际上是不会再添加用户名密码过滤器）
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 配置异常处理器
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                                .accessDeniedHandler(accessDeniedHandler);

        //允许跨域
        http.cors();
    }

}
