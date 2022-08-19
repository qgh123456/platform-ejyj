package com.atqgh.system.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.atqgh.system.provider.entity.SysDictType;
import com.atqgh.system.provider.vo.SysDictTypeQueryVo;
import org.springframework.beans.BeanUtils;

/**
 * 字典类型表.
 * 
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Mapper
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    /**
    * 构建查询参数对象.
    *
    * @param queryVo 查询实体
    * @return 查询对象
    */
    default LambdaQueryWrapper<SysDictType> buildQueryPageWrapper(SysDictTypeQueryVo queryVo) {

        SysDictType entity = new SysDictType();
        BeanUtils.copyProperties(queryVo, entity);
        LambdaQueryWrapper<SysDictType> wrapper = new QueryWrapper<SysDictType>().lambda();
        // TODO 构建查询参数
        return wrapper;
    }

}
