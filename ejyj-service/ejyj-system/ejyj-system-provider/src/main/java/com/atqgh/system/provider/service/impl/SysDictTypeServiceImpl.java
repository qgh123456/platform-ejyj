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
import com.atqgh.system.provider.mapper.SysDictTypeMapper;
import com.atqgh.system.provider.entity.SysDictType;
import com.atqgh.system.provider.service.SysDictTypeService;
import com.atqgh.system.provider.vo.SysDictTypeQueryVo;
import com.atqgh.system.provider.vo.SysDictTypeAddVo;
import com.atqgh.system.provider.vo.SysDictTypeUptVo;
import com.atqgh.system.provider.dto.SysDictTypeDto;
import com.atqgh.system.provider.dto.SysDictTypePageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 字典类型表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Slf4j
@Service("sysDictTypeService")
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService {

    @Resource
    private SysDictTypeMapper sysDictTypeMapper;

    @Override
    public int insert(@NonNull SysDictTypeAddVo addVo) {

        SysDictType addEntity = new SysDictType();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysDictTypeUptVo updateVo) {

        SysDictType uptEntity = new SysDictType();
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
    public SysDictTypeDto getDetail(@NonNull String dictType) {

        SysDictType entity = this.baseMapper.selectById(dictType);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysDictTypeDto dto = new SysDictTypeDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysDictTypePageDto> queryPageByWrapper(@NonNull SysDictTypeQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysDictType> queryWrapper = this.sysDictTypeMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysDictType> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysDictTypePageDto.class));
    }

}
