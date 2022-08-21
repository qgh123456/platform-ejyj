package com.atqgh.system.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import com.atqgh.common.core.utils.WebUtil;
import org.springframework.stereotype.Service;
import com.atqgh.common.core.utils.PropertiesCopyUtils;
import com.atqgh.system.provider.mapper.SysRoleDeptMapper;
import com.atqgh.system.provider.entity.SysRoleDept;
import com.atqgh.system.provider.service.SysRoleDeptService;
import com.atqgh.system.provider.vo.SysRoleDeptQueryVo;
import com.atqgh.system.provider.vo.SysRoleDeptAddVo;
import com.atqgh.system.provider.vo.SysRoleDeptUptVo;
import com.atqgh.system.provider.dto.SysRoleDeptDto;
import com.atqgh.system.provider.dto.SysRoleDeptPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.atqgh.common.core.exception.MicroException;
import com.atqgh.common.core.enums.ResultStatus;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 角色和部门关联表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Slf4j
@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptMapper, SysRoleDept> implements SysRoleDeptService {

    @Resource
    private SysRoleDeptMapper sysRoleDeptMapper;

    @Override
    public int insert(@NonNull SysRoleDeptAddVo addVo) {

        SysRoleDept addEntity = new SysRoleDept();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysRoleDeptUptVo updateVo) {

        SysRoleDept uptEntity = new SysRoleDept();
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
    public SysRoleDeptDto getDetail(@NonNull String roleCode) {

        SysRoleDept entity = this.baseMapper.selectById(roleCode);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysRoleDeptDto dto = new SysRoleDeptDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysRoleDeptPageDto> queryPageByWrapper(@NonNull SysRoleDeptQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysRoleDept> queryWrapper = this.sysRoleDeptMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysRoleDept> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysRoleDeptPageDto.class));
    }

}
