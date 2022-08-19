package com.atqgh.system.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.atqgh.system.provider.entity.SysLogininfor;
import com.atqgh.system.provider.vo.SysLogininforQueryVo;
import org.springframework.beans.BeanUtils;

/**
 * 系统访问记录.
 * 
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Mapper
public interface SysLogininforMapper extends BaseMapper<SysLogininfor> {

    /**
    * 构建查询参数对象.
    *
    * @param queryVo 查询实体
    * @return 查询对象
    */
    default LambdaQueryWrapper<SysLogininfor> buildQueryPageWrapper(SysLogininforQueryVo queryVo) {

        SysLogininfor entity = new SysLogininfor();
        BeanUtils.copyProperties(queryVo, entity);
        LambdaQueryWrapper<SysLogininfor> wrapper = new QueryWrapper<SysLogininfor>().lambda();
        // TODO 构建查询参数
        return wrapper;
    }

}
