package com.atqgh.system.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import com.atqgh.common.core.utils.WebUtil;
import org.springframework.stereotype.Service;
import com.atqgh.common.core.utils.PropertiesCopyUtils;
import com.atqgh.system.provider.mapper.SysOperLogMapper;
import com.atqgh.system.provider.entity.SysOperLog;
import com.atqgh.system.provider.service.SysOperLogService;
import com.atqgh.system.provider.vo.SysOperLogQueryVo;
import com.atqgh.system.provider.vo.SysOperLogAddVo;
import com.atqgh.system.provider.vo.SysOperLogUptVo;
import com.atqgh.system.provider.dto.SysOperLogDto;
import com.atqgh.system.provider.dto.SysOperLogPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.atqgh.common.core.exception.MicroException;
import com.atqgh.common.core.enums.ResultStatus;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 操作日志记录 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Slf4j
@Service("sysOperLogService")
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements SysOperLogService {

    @Resource
    private SysOperLogMapper sysOperLogMapper;

    @Override
    public int insert(@NonNull SysOperLogAddVo addVo) {

        SysOperLog addEntity = new SysOperLog();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysOperLogUptVo updateVo) {

        SysOperLog uptEntity = new SysOperLog();
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
    public SysOperLogDto getDetail(@NonNull Long operId) {

        SysOperLog entity = this.baseMapper.selectById(operId);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysOperLogDto dto = new SysOperLogDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysOperLogPageDto> queryPageByWrapper(@NonNull SysOperLogQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysOperLog> queryWrapper = this.sysOperLogMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysOperLog> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysOperLogPageDto.class));
    }

}
