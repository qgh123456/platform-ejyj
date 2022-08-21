package com.atqgh.system.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import com.atqgh.common.core.utils.WebUtil;
import org.springframework.stereotype.Service;
import com.atqgh.common.core.utils.PropertiesCopyUtils;
import com.atqgh.system.provider.mapper.SysRoleMenuMapper;
import com.atqgh.system.provider.entity.SysRoleMenu;
import com.atqgh.system.provider.service.SysRoleMenuService;
import com.atqgh.system.provider.vo.SysRoleMenuQueryVo;
import com.atqgh.system.provider.vo.SysRoleMenuAddVo;
import com.atqgh.system.provider.vo.SysRoleMenuUptVo;
import com.atqgh.system.provider.dto.SysRoleMenuDto;
import com.atqgh.system.provider.dto.SysRoleMenuPageDto;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import com.atqgh.common.core.exception.MicroException;
import com.atqgh.common.core.enums.ResultStatus;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;

/**
 * 角色和菜单关联表 业务逻辑.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Slf4j
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public int insert(@NonNull SysRoleMenuAddVo addVo) {

        SysRoleMenu addEntity = new SysRoleMenu();
        BeanUtils.copyProperties(addVo, addEntity);
        return this.baseMapper.insert(addEntity);
    }

    @Override
    public int update(@NonNull SysRoleMenuUptVo updateVo) {

        SysRoleMenu uptEntity = new SysRoleMenu();
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
    public SysRoleMenuDto getDetail(@NonNull String roleCode) {

        SysRoleMenu entity = this.baseMapper.selectById(roleCode);
        if (ObjectUtils.isEmpty(entity)) {
            throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), "请输入正确的数据");
        }
        SysRoleMenuDto dto = new SysRoleMenuDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public PageInfo<SysRoleMenuPageDto> queryPageByWrapper(@NonNull SysRoleMenuQueryVo queryVo) {

        // 设置分页
        WebUtil.startPage();
        // 构建查询条件
        LambdaQueryWrapper<SysRoleMenu> queryWrapper = this.sysRoleMenuMapper.buildQueryPageWrapper(queryVo);
        // 根据提交查询
        List<SysRoleMenu> list = this.baseMapper.selectList(queryWrapper);
        // 根据条件获取总数
        return new PageInfo<>(PropertiesCopyUtils.entityToDto(list, SysRoleMenuPageDto.class));
    }

}
