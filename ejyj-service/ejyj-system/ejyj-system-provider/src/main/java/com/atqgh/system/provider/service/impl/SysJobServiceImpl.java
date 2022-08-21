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
import com.atqgh.system.provider.mapper.SysJobMapper;
import com.atqgh.system.provider.entity.SysJob;
import com.atqgh.system.provider.service.SysJobService;
import com.atqgh.system.provider.vo.SysJobQueryVo;
import com.atqgh.system.provider.vo.SysJobAddVo;
import com.atqgh.system.provider.vo.SysJobUptVo;
import com.atqgh.system.provider.dto.SysJobDto;
import com.atqgh.system.provider.dto.SysJobPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 定时任务调度表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Slf4j
@Service("sysJobService")
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements SysJobService {

    @Resource
    private SysJobMapper sysJobMapper;

    @Override
    public int insert(@NonNull SysJobAddVo addVo) {

        SysJob addEntity = new SysJob();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysJobUptVo updateVo) {

        SysJob uptEntity = new SysJob();
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
    public SysJobDto getDetail(@NonNull Long id) {

        SysJob entity = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysJobDto dto = new SysJobDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysJobPageDto> queryPageByWrapper(@NonNull SysJobQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysJob> queryWrapper = this.sysJobMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysJob> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysJobPageDto.class));
    }

}
