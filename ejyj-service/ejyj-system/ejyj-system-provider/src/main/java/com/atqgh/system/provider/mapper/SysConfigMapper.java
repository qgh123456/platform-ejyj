package com.atqgh.system.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.atqgh.system.provider.entity.SysConfig;
import com.atqgh.system.provider.vo.SysConfigQueryVo;
import org.springframework.beans.BeanUtils;

/**
 * 参数配置表.
 * 
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Mapper
public interface SysConfigMapper extends BaseMapper<SysConfig> {

    /**
    * 构建查询参数对象.
    *
    * @param queryVo 查询实体
    * @return 查询对象
    */
    default LambdaQueryWrapper<SysConfig> buildQueryPageWrapper(SysConfigQueryVo queryVo) {

        SysConfig entity = new SysConfig();
        BeanUtils.copyProperties(queryVo, entity);
        LambdaQueryWrapper<SysConfig> wrapper = new QueryWrapper<SysConfig>().lambda();
        // TODO 构建查询参数
        return wrapper;
    }

}
