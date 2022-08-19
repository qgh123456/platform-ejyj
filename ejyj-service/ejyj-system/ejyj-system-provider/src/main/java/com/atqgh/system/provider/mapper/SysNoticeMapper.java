package com.atqgh.system.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.atqgh.system.provider.entity.SysNotice;
import com.atqgh.system.provider.vo.SysNoticeQueryVo;
import org.springframework.beans.BeanUtils;

/**
 * 通知公告表.
 * 
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@Mapper
public interface SysNoticeMapper extends BaseMapper<SysNotice> {

    /**
    * 构建查询参数对象.
    *
    * @param queryVo 查询实体
    * @return 查询对象
    */
    default LambdaQueryWrapper<SysNotice> buildQueryPageWrapper(SysNoticeQueryVo queryVo) {

        SysNotice entity = new SysNotice();
        BeanUtils.copyProperties(queryVo, entity);
        LambdaQueryWrapper<SysNotice> wrapper = new QueryWrapper<SysNotice>().lambda();
        // TODO 构建查询参数
        return wrapper;
    }

}
