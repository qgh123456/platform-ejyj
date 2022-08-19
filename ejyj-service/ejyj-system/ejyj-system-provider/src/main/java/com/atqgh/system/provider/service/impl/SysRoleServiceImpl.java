package com.atqgh.system.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import com.atqgh.common.utils.WebUtil;
import org.springframework.stereotype.Service;
import com.atqgh.common.utils.PropertiesCopyUtils;
import com.atqgh.system.provider.mapper.SysRoleMapper;
import com.atqgh.system.provider.entity.SysRole;
import com.atqgh.system.provider.service.SysRoleService;
import com.atqgh.system.provider.vo.SysRoleQueryVo;
import com.atqgh.system.provider.vo.SysRoleAddVo;
import com.atqgh.system.provider.vo.SysRoleUptVo;
import com.atqgh.system.provider.dto.SysRoleDto;
import com.atqgh.system.provider.dto.SysRolePageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.atqgh.common.exception.MicroException;
import com.atqgh.common.enums.ResultStatus;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 角色信息表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Slf4j
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public int insert(@NonNull SysRoleAddVo addVo) {

        SysRole addEntity = new SysRole();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysRoleUptVo updateVo) {

        SysRole uptEntity = new SysRole();
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
    public SysRoleDto getDetail(@NonNull Long id) {

        SysRole entity = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysRoleDto dto = new SysRoleDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysRolePageDto> queryPageByWrapper(@NonNull SysRoleQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysRole> queryWrapper = this.sysRoleMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysRole> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysRolePageDto.class));
    }

}
