package com.atqgh.system.provider.service.impl;

import com.atqgh.common.core.enums.ResultStatus;
import com.atqgh.common.core.exception.MicroException;
import com.atqgh.common.core.utils.PropertiesCopyUtils;
import com.atqgh.common.core.utils.WebUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import com.atqgh.system.provider.mapper.SysDeptMapper;
import com.atqgh.system.provider.entity.SysDept;
import com.atqgh.system.provider.service.SysDeptService;
import com.atqgh.system.provider.vo.SysDeptQueryVo;
import com.atqgh.system.provider.vo.SysDeptAddVo;
import com.atqgh.system.provider.vo.SysDeptUptVo;
import com.atqgh.system.provider.dto.SysDeptDto;
import com.atqgh.system.provider.dto.SysDeptPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 部门表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Slf4j
@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;

    @Override
    public int insert(@NonNull SysDeptAddVo addVo) {

        SysDept addEntity = new SysDept();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysDeptUptVo updateVo) {

        SysDept uptEntity = new SysDept();
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
    public SysDeptDto getDetail(@NonNull Long id) {

        SysDept entity = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysDeptDto dto = new SysDeptDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysDeptPageDto> queryPageByWrapper(@NonNull SysDeptQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysDept> queryWrapper = this.sysDeptMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysDept> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysDeptPageDto.class));
    }

}
