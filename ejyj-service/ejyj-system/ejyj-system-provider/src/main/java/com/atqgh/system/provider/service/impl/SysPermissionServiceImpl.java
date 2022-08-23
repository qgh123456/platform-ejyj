package com.atqgh.system.provider.service.impl;

import com.atqgh.common.core.constants.SystemConstants;
import com.atqgh.system.provider.mapper.SysRoleMenuMapper;
import com.atqgh.system.provider.service.SysPermissionService;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import lombok.NonNull;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

/**
 * 权限接口 .
 *
 * @author Mubai
 * @since 2022/8/22 9:43 下午
 **/
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public Set<String> getPermissions(@NonNull String userCode, Set<String> rolekey) {

        Set<String> permissions = new HashSet<>();
        if (ObjectUtils.isNotEmpty(rolekey) && rolekey.contains(SystemConstants.Role.ADMIN)) {
            // 如果是超级管理员，直接全部角色
            permissions.add(SystemConstants.Perm.ADMIN_PERS);
        } else {
            // 通过用户编码获取权限
            permissions = this.sysRoleMenuMapper.getPermissions(userCode);
            if (ObjectUtils.isNotEmpty(permissions)) {
                permissions = permissions.stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toSet());
            }
        }
        return permissions;
    }

}
