package com.atqgh.system.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.atqgh.system.provider.entity.SysUserRole;
import com.atqgh.system.provider.vo.SysUserRoleQueryVo;
import org.springframework.beans.BeanUtils;

/**
 * 用户和角色关联表.
 * 
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
    * 构建查询参数对象.
    *
    * @param queryVo 查询实体
    * @return 查询对象
    */
    default LambdaQueryWrapper<SysUserRole> buildQueryPageWrapper(SysUserRoleQueryVo queryVo) {

        SysUserRole entity = new SysUserRole();
        BeanUtils.copyProperties(queryVo, entity);
        LambdaQueryWrapper<SysUserRole> wrapper = new QueryWrapper<SysUserRole>().lambda();
        // TODO 构建查询参数
        return wrapper;
    }

}
