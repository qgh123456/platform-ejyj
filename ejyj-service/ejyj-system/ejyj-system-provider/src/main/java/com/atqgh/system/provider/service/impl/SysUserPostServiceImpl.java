package com.atqgh.system.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import com.atqgh.common.core.utils.WebUtil;
import org.springframework.stereotype.Service;
import com.atqgh.common.core.utils.PropertiesCopyUtils;
import com.atqgh.system.provider.mapper.SysUserPostMapper;
import com.atqgh.system.provider.entity.SysUserPost;
import com.atqgh.system.provider.service.SysUserPostService;
import com.atqgh.system.provider.vo.SysUserPostQueryVo;
import com.atqgh.system.provider.vo.SysUserPostAddVo;
import com.atqgh.system.provider.vo.SysUserPostUptVo;
import com.atqgh.system.provider.dto.SysUserPostDto;
import com.atqgh.system.provider.dto.SysUserPostPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.atqgh.common.core.exception.MicroException;
import com.atqgh.common.core.enums.ResultStatus;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 用户与岗位关联表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Slf4j
@Service("sysUserPostService")
public class SysUserPostServiceImpl extends ServiceImpl<SysUserPostMapper, SysUserPost> implements SysUserPostService {

    @Resource
    private SysUserPostMapper sysUserPostMapper;

    @Override
    public int insert(@NonNull SysUserPostAddVo addVo) {

        SysUserPost addEntity = new SysUserPost();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysUserPostUptVo updateVo) {

        SysUserPost uptEntity = new SysUserPost();
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
    public SysUserPostDto getDetail(@NonNull String userCode) {

        SysUserPost entity = this.baseMapper.selectById(userCode);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysUserPostDto dto = new SysUserPostDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysUserPostPageDto> queryPageByWrapper(@NonNull SysUserPostQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysUserPost> queryWrapper = this.sysUserPostMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysUserPost> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysUserPostPageDto.class));
    }

}
