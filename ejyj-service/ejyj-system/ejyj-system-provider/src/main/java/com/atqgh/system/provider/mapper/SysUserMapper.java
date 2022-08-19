package com.atqgh.system.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.atqgh.system.provider.entity.SysUser;
import com.atqgh.system.provider.vo.SysUserQueryVo;
import org.springframework.beans.BeanUtils;

/**
 * 用户信息表.
 * 
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
    * 构建查询参数对象.
    *
    * @param queryVo 查询实体
    * @return 查询对象
    */
    default LambdaQueryWrapper<SysUser> buildQueryPageWrapper(SysUserQueryVo queryVo) {

        SysUser entity = new SysUser();
        BeanUtils.copyProperties(queryVo, entity);
        LambdaQueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>().lambda();
        // TODO 构建查询参数
        return wrapper;
    }

}
