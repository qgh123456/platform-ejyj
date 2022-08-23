package com.atqgh.system.provider.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.Data;

/**
 * 登陆用户.
 *
 * @author Mubai
 * @since 2022/8/22 3:39 下午
 **/
@Data
public class LoginUserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * token.
     */
    private String token;

    /**
     * 用户名编码.
     */
    private String userCode;

    /**
     * 用户名.
     */
    private String userName;

    /**
     * 登录时间.
     */
    private Long loginTime;

    /**
     * 过期时间.
     */
    private Long expireTime;

    /**
     * 登录IP地址.
     */
    private String ipaddr;

    /**
     * 权限列表.
     */
    private Set<String> permissions;

    /**
     * 角色列表.
     */
    private Set<String> roles;

    /**
     * 用户信息.
     */
    private SysUserDto sysUser;

}
