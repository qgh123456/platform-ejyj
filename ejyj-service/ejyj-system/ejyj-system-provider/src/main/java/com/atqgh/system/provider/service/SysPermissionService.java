package com.atqgh.system.provider.service;

import java.util.Set;
import lombok.NonNull;

/**
 * 权限接口.
 *
 * @author Mubai
 * @since 2022/8/22 9:43 下午
 **/
public interface SysPermissionService {

    /**
     * 获取菜单数据权限.
     *
     * @param userCode 用户编码
     * @param roleKeys 角色key
     * @return 菜单权限信息
     */
    Set<String> getPermissions(@NonNull String userCode, Set<String> roleKeys);
}
