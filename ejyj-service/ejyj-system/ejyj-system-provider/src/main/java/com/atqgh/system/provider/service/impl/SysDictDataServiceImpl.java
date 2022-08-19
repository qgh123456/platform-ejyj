package com.atqgh.system.provider.service.impl;

import com.atqgh.common.enums.ResultStatus;
import com.atqgh.common.exception.MicroException;
import com.atqgh.common.utils.PropertiesCopyUtils;
import com.atqgh.common.utils.WebUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import com.atqgh.system.provider.mapper.SysDictDataMapper;
import com.atqgh.system.provider.entity.SysDictData;
import com.atqgh.system.provider.service.SysDictDataService;
import com.atqgh.system.provider.vo.SysDictDataQueryVo;
import com.atqgh.system.provider.vo.SysDictDataAddVo;
import com.atqgh.system.provider.vo.SysDictDataUptVo;
import com.atqgh.system.provider.dto.SysDictDataDto;
import com.atqgh.system.provider.dto.SysDictDataPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 字典数据表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Slf4j
@Service("sysDictDataService")
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements SysDictDataService {

    @Resource
    private SysDictDataMapper sysDictDataMapper;

    @Override
    public int insert(@NonNull SysDictDataAddVo addVo) {

        SysDictData addEntity = new SysDictData();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysDictDataUptVo updateVo) {

        SysDictData uptEntity = new SysDictData();
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
    public SysDictDataDto getDetail(@NonNull Long id) {

        SysDictData entity = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysDictDataDto dto = new SysDictDataDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysDictDataPageDto> queryPageByWrapper(@NonNull SysDictDataQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysDictData> queryWrapper = this.sysDictDataMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysDictData> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysDictDataPageDto.class));
    }

}
