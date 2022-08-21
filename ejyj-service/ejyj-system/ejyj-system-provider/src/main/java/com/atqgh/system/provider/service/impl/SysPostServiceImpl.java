package com.atqgh.system.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import com.atqgh.common.core.utils.WebUtil;
import org.springframework.stereotype.Service;
import com.atqgh.common.core.utils.PropertiesCopyUtils;
import com.atqgh.system.provider.mapper.SysPostMapper;
import com.atqgh.system.provider.entity.SysPost;
import com.atqgh.system.provider.service.SysPostService;
import com.atqgh.system.provider.vo.SysPostQueryVo;
import com.atqgh.system.provider.vo.SysPostAddVo;
import com.atqgh.system.provider.vo.SysPostUptVo;
import com.atqgh.system.provider.dto.SysPostDto;
import com.atqgh.system.provider.dto.SysPostPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.atqgh.common.core.exception.MicroException;
import com.atqgh.common.core.enums.ResultStatus;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 岗位信息表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Slf4j
@Service("sysPostService")
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements SysPostService {

    @Resource
    private SysPostMapper sysPostMapper;

    @Override
    public int insert(@NonNull SysPostAddVo addVo) {

        SysPost addEntity = new SysPost();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysPostUptVo updateVo) {

        SysPost uptEntity = new SysPost();
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
    public SysPostDto getDetail(@NonNull Long id) {

        SysPost entity = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysPostDto dto = new SysPostDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysPostPageDto> queryPageByWrapper(@NonNull SysPostQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysPost> queryWrapper = this.sysPostMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysPost> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysPostPageDto.class));
    }

}
