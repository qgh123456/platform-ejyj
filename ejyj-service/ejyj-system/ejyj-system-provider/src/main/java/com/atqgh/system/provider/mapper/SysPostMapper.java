package com.atqgh.system.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.atqgh.system.provider.entity.SysPost;
import com.atqgh.system.provider.vo.SysPostQueryVo;
import org.springframework.beans.BeanUtils;

/**
 * 岗位信息表.
 * 
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Mapper
public interface SysPostMapper extends BaseMapper<SysPost> {

    /**
    * 构建查询参数对象.
    *
    * @param queryVo 查询实体
    * @return 查询对象
    */
    default LambdaQueryWrapper<SysPost> buildQueryPageWrapper(SysPostQueryVo queryVo) {

        SysPost entity = new SysPost();
        BeanUtils.copyProperties(queryVo, entity);
        LambdaQueryWrapper<SysPost> wrapper = new QueryWrapper<SysPost>().lambda();
        // TODO 构建查询参数
        return wrapper;
    }

}
