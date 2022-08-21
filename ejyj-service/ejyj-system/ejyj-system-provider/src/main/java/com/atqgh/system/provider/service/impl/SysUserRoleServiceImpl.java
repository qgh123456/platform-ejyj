package com.atqgh.system.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import com.atqgh.common.core.utils.WebUtil;
import org.springframework.stereotype.Service;
import com.atqgh.common.core.utils.PropertiesCopyUtils;
import com.atqgh.system.provider.mapper.SysUserRoleMapper;
import com.atqgh.system.provider.entity.SysUserRole;
import com.atqgh.system.provider.service.SysUserRoleService;
import com.atqgh.system.provider.vo.SysUserRoleQueryVo;
import com.atqgh.system.provider.vo.SysUserRoleAddVo;
import com.atqgh.system.provider.vo.SysUserRoleUptVo;
import com.atqgh.system.provider.dto.SysUserRoleDto;
import com.atqgh.system.provider.dto.SysUserRolePageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.atqgh.common.core.exception.MicroException;
import com.atqgh.common.core.enums.ResultStatus;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 用户和角色关联表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Slf4j
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int insert(@NonNull SysUserRoleAddVo addVo) {

        SysUserRole addEntity = new SysUserRole();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysUserRoleUptVo updateVo) {

        SysUserRole uptEntity = new SysUserRole();
        BeanUtils.copyProperties(updateVo, uptEntity);
        int count = this.baseMapper.updateById(uptEntity);
        if (count == 0) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "修改失败");
        }
        return count;
    }

    @Override
    public void batchDel(@NonNull Set<String> pks) {

        this.baseMapper.deleteBatchIds(pks);
    }

    @Override
    public SysUserRoleDto getDetail(@NonNull String userCode) {

        SysUserRole entity = this.baseMapper.selectById(userCode);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysUserRoleDto dto = new SysUserRoleDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysUserRolePageDto> queryPageByWrapper(@NonNull SysUserRoleQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysUserRole> queryWrapper = this.sysUserRoleMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysUserRole> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysUserRolePageDto.class));
    }

}
