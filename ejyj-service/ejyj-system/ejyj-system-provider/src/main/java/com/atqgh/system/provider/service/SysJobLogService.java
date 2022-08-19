package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysJobLogQueryVo;
import com.atqgh.system.provider.vo.SysJobLogAddVo;
import com.atqgh.system.provider.vo.SysJobLogUptVo;
import com.atqgh.system.provider.dto.SysJobLogDto;
import com.atqgh.system.provider.dto.SysJobLogPageDto;
import com.atqgh.system.provider.entity.SysJobLog;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 定时任务调度日志表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
public interface SysJobLogService extends IService<SysJobLog> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysJobLogAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysJobLogUptVo updateVo);

     /**
     * 根据主键批量删除数据.
     *
     * @param pks 主键
     */
    void batchDel(@NonNull Set<Long> pks);

    /**
     * 根据主键查询.
     *
     * @param id 主键
     * @return 返回集合数据
     */
    SysJobLogDto getDetail(@NonNull Long id);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysJobLogPageDto> queryPageByWrapper(@NonNull SysJobLogQueryVo queryVo);

}
