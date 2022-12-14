package com.atqgh.system.provider.service.impl;

import com.atqgh.system.provider.dto.LoginUserDto;
import com.atqgh.system.provider.mapper.SysRoleMapper;
import com.atqgh.system.provider.service.SysPermissionService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import com.atqgh.common.core.utils.WebUtil;
import org.springframework.stereotype.Service;
import com.atqgh.common.core.utils.PropertiesCopyUtils;
import com.atqgh.system.provider.mapper.SysUserMapper;
import com.atqgh.system.provider.entity.SysUser;
import com.atqgh.system.provider.service.SysUserService;
import com.atqgh.system.provider.vo.SysUserQueryVo;
import com.atqgh.system.provider.vo.SysUserAddVo;
import com.atqgh.system.provider.vo.SysUserUptVo;
import com.atqgh.system.provider.dto.SysUserDto;
import com.atqgh.system.provider.dto.SysUserPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.atqgh.common.core.exception.MicroException;
import com.atqgh.common.core.enums.ResultStatus;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 用户信息表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Slf4j
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysPermissionService sysPermissionService;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public int insert(@NonNull SysUserAddVo addVo) {

        SysUser addEntity = new SysUser();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysUserUptVo updateVo) {

        SysUser uptEntity = new SysUser();
        BeanUtils.copyProperties(updateVo, uptEntity);
        int count = this.baseMapper.updateById(uptEntity);
        if (count == 0) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "修改失败");
        }
        return count;
    }

    @Override
    public void batchDel(@NonNull Set<Long> pks) {

        this.baseMapper.deleteBatchIds(pks);
    }

    @Override
    public SysUserDto getDetail(@NonNull Long id) {

        SysUser entity = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysUserDto dto = new SysUserDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysUserPageDto> queryPageByWrapper(@NonNull SysUserQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysUser> queryWrapper = this.sysUserMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysUser> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysUserPageDto.class));
    }

    @Override
    public LoginUserDto getInfo(@NonNull String userName) {

        // 通过用户名获取用户详情
        LambdaQueryWrapper<SysUser> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.eq(SysUser::getUserName, userName);
        SysUser sysUser = this.sysUserMapper.selectOne(userQueryWrapper);
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "用户名错误");
        }
        LoginUserDto sysUserDto = new LoginUserDto();
        sysUserDto.setSysUser(PropertiesCopyUtils.entityToDto(sysUser, SysUserDto.class));

        // 获取角色集合
        Set<String> roleKeys = this.sysRoleMapper.getRoleKeys(sysUser.getCode());
        sysUserDto.setRoles(roleKeys);

        // 获取权限集合
        Set<String> pers = this.sysPermissionService.getPermissions(sysUser.getCode(), roleKeys);
        sysUserDto.setPermissions(pers);

        return sysUserDto;
    }

}
