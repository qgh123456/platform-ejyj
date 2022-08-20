package com.atqgh.common.security.domain;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 登录的对象.
 *
 * @author Mubai
 * @date 2022/7/10 8:56 下午
 **/
@Data
@NoArgsConstructor
public class LoginUserDetailDto implements UserDetails {

    private LoginSysUserDto loginSysUserDto;

    /**
     * 权限.
     */
    private List<String> permissions;

    /**
     * 已启用.
     */
    private boolean isEnabled = true;

    @JSONField(serialize = false)
    private List<SimpleGrantedAuthority> grantedAuthorities;

    public LoginUserDetailDto(List<String> permissions, LoginSysUserDto loginSysUserDto) {

        this.permissions = permissions;
        this.loginSysUserDto = loginSysUserDto;
    }

    public LoginUserDetailDto(List<String> permissions) {

        this.permissions = permissions;
    }

    /**
     * 获取权限信息.
     * @return 权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (ObjectUtils.isNotEmpty(grantedAuthorities)) {
            return grantedAuthorities;
        }
        if (ObjectUtils.isEmpty(grantedAuthorities) && ObjectUtils.isNotEmpty(this.permissions)) {
            grantedAuthorities = this.permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.loginSysUserDto.getPassword();
    }

    @Override
    public String getUsername() {
        return this.loginSysUserDto.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
