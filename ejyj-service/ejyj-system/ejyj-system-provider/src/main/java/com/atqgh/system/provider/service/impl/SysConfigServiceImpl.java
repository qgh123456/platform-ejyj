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
import com.atqgh.system.provider.mapper.SysConfigMapper;
import com.atqgh.system.provider.entity.SysConfig;
import com.atqgh.system.provider.service.SysConfigService;
import com.atqgh.system.provider.vo.SysConfigQueryVo;
import com.atqgh.system.provider.vo.SysConfigAddVo;
import com.atqgh.system.provider.vo.SysConfigUptVo;
import com.atqgh.system.provider.dto.SysConfigDto;
import com.atqgh.system.provider.dto.SysConfigPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 参数配置表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Slf4j
@Service("sysConfigService")
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {

    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public int insert(@NonNull SysConfigAddVo addVo) {

        SysConfig addEntity = new SysConfig();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysConfigUptVo updateVo) {

        SysConfig uptEntity = new SysConfig();
        BeanUtils.copyProperties(updateVo, uptEntity);
        int count = this.baseMapper.updateById(uptEntity);
        if (count == 0) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "修改失败");
        }
        return count;
    }

    @Override
    public void batchDel(@NonNull Set<Integer> pks) {

        this.baseMapper.deleteBatchIds(pks);
    }

    @Override
    public SysConfigDto getDetail(@NonNull Integer id) {

        SysConfig entity = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysConfigDto dto = new SysConfigDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysConfigPageDto> queryPageByWrapper(@NonNull SysConfigQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysConfig> queryWrapper = this.sysConfigMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysConfig> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysConfigPageDto.class));
    }

}
