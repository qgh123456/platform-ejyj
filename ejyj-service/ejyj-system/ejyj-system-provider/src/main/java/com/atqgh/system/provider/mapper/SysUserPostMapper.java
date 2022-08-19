package com.atqgh.system.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.atqgh.system.provider.entity.SysUserPost;
import com.atqgh.system.provider.vo.SysUserPostQueryVo;
import org.springframework.beans.BeanUtils;

/**
 * 用户与岗位关联表.
 * 
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Mapper
public interface SysUserPostMapper extends BaseMapper<SysUserPost> {

    /**
    * 构建查询参数对象.
    *
    * @param queryVo 查询实体
    * @return 查询对象
    */
    default LambdaQueryWrapper<SysUserPost> buildQueryPageWrapper(SysUserPostQueryVo queryVo) {

        SysUserPost entity = new SysUserPost();
        BeanUtils.copyProperties(queryVo, entity);
        LambdaQueryWrapper<SysUserPost> wrapper = new QueryWrapper<SysUserPost>().lambda();
        // TODO 构建查询参数
        return wrapper;
    }

}
