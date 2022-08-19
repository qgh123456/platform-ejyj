package com.atqgh.system.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.atqgh.system.provider.entity.SysOperLog;
import com.atqgh.system.provider.vo.SysOperLogQueryVo;
import org.springframework.beans.BeanUtils;

/**
 * 操作日志记录.
 * 
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Mapper
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {

    /**
    * 构建查询参数对象.
    *
    * @param queryVo 查询实体
    * @return 查询对象
    */
    default LambdaQueryWrapper<SysOperLog> buildQueryPageWrapper(SysOperLogQueryVo queryVo) {

        SysOperLog entity = new SysOperLog();
        BeanUtils.copyProperties(queryVo, entity);
        LambdaQueryWrapper<SysOperLog> wrapper = new QueryWrapper<SysOperLog>().lambda();
        // TODO 构建查询参数
        return wrapper;
    }

}
