package com.atqgh.system.provider.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * 权限的对象.
 * @author Mubai
 * @date 2022/7/12 10:41 下午
 **/
@Data
public class SysPermissDto implements Serializable {

    /**
     * 页面.
     */
    private String component;

    /**
     * 路由地址.
     */
    private String path;

    /**
     * 权限.
     */
    private String perms;

}
