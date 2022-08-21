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
import com.atqgh.system.provider.mapper.SysMenuMapper;
import com.atqgh.system.provider.entity.SysMenu;
import com.atqgh.system.provider.service.SysMenuService;
import com.atqgh.system.provider.vo.SysMenuQueryVo;
import com.atqgh.system.provider.vo.SysMenuAddVo;
import com.atqgh.system.provider.vo.SysMenuUptVo;
import com.atqgh.system.provider.dto.SysMenuDto;
import com.atqgh.system.provider.dto.SysMenuPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 菜单权限表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Slf4j
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public int insert(@NonNull SysMenuAddVo addVo) {

        SysMenu addEntity = new SysMenu();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysMenuUptVo updateVo) {

        SysMenu uptEntity = new SysMenu();
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
    public SysMenuDto getDetail(@NonNull Long id) {

        SysMenu entity = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysMenuDto dto = new SysMenuDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysMenuPageDto> queryPageByWrapper(@NonNull SysMenuQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysMenu> queryWrapper = this.sysMenuMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysMenu> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysMenuPageDto.class));
    }

}
