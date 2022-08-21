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
import com.atqgh.system.provider.mapper.SysJobLogMapper;
import com.atqgh.system.provider.entity.SysJobLog;
import com.atqgh.system.provider.service.SysJobLogService;
import com.atqgh.system.provider.vo.SysJobLogQueryVo;
import com.atqgh.system.provider.vo.SysJobLogAddVo;
import com.atqgh.system.provider.vo.SysJobLogUptVo;
import com.atqgh.system.provider.dto.SysJobLogDto;
import com.atqgh.system.provider.dto.SysJobLogPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 定时任务调度日志表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Slf4j
@Service("sysJobLogService")
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLog> implements SysJobLogService {

    @Resource
    private SysJobLogMapper sysJobLogMapper;

    @Override
    public int insert(@NonNull SysJobLogAddVo addVo) {

        SysJobLog addEntity = new SysJobLog();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysJobLogUptVo updateVo) {

        SysJobLog uptEntity = new SysJobLog();
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
    public SysJobLogDto getDetail(@NonNull Long id) {

        SysJobLog entity = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysJobLogDto dto = new SysJobLogDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysJobLogPageDto> queryPageByWrapper(@NonNull SysJobLogQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysJobLog> queryWrapper = this.sysJobLogMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysJobLog> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysJobLogPageDto.class));
    }

}
