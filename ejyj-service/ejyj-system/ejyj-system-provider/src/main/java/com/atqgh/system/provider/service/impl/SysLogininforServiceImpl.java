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
import com.atqgh.system.provider.mapper.SysLogininforMapper;
import com.atqgh.system.provider.entity.SysLogininfor;
import com.atqgh.system.provider.service.SysLogininforService;
import com.atqgh.system.provider.vo.SysLogininforQueryVo;
import com.atqgh.system.provider.vo.SysLogininforAddVo;
import com.atqgh.system.provider.vo.SysLogininforUptVo;
import com.atqgh.system.provider.dto.SysLogininforDto;
import com.atqgh.system.provider.dto.SysLogininforPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 系统访问记录 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Slf4j
@Service("sysLogininforService")
public class SysLogininforServiceImpl extends ServiceImpl<SysLogininforMapper, SysLogininfor> implements SysLogininforService {

    @Resource
    private SysLogininforMapper sysLogininforMapper;

    @Override
    public int insert(@NonNull SysLogininforAddVo addVo) {

        SysLogininfor addEntity = new SysLogininfor();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysLogininforUptVo updateVo) {

        SysLogininfor uptEntity = new SysLogininfor();
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
    public SysLogininforDto getDetail(@NonNull Long id) {

        SysLogininfor entity = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysLogininforDto dto = new SysLogininforDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysLogininforPageDto> queryPageByWrapper(@NonNull SysLogininforQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysLogininfor> queryWrapper = this.sysLogininforMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysLogininfor> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysLogininforPageDto.class));
    }

}
