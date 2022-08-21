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
import com.atqgh.system.provider.mapper.SysNoticeMapper;
import com.atqgh.system.provider.entity.SysNotice;
import com.atqgh.system.provider.service.SysNoticeService;
import com.atqgh.system.provider.vo.SysNoticeQueryVo;
import com.atqgh.system.provider.vo.SysNoticeAddVo;
import com.atqgh.system.provider.vo.SysNoticeUptVo;
import com.atqgh.system.provider.dto.SysNoticeDto;
import com.atqgh.system.provider.dto.SysNoticePageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 通知公告表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Slf4j
@Service("sysNoticeService")
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice> implements SysNoticeService {

    @Resource
    private SysNoticeMapper sysNoticeMapper;

    @Override
    public int insert(@NonNull SysNoticeAddVo addVo) {

        SysNotice addEntity = new SysNotice();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysNoticeUptVo updateVo) {

        SysNotice uptEntity = new SysNotice();
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
    public SysNoticeDto getDetail(@NonNull Integer id) {

        SysNotice entity = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysNoticeDto dto = new SysNoticeDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysNoticePageDto> queryPageByWrapper(@NonNull SysNoticeQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysNotice> queryWrapper = this.sysNoticeMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysNotice> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysNoticePageDto.class));
    }

}
