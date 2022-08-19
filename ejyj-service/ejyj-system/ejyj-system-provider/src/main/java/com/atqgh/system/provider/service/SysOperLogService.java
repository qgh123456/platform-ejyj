package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysOperLogQueryVo;
import com.atqgh.system.provider.vo.SysOperLogAddVo;
import com.atqgh.system.provider.vo.SysOperLogUptVo;
import com.atqgh.system.provider.dto.SysOperLogDto;
import com.atqgh.system.provider.dto.SysOperLogPageDto;
import com.atqgh.system.provider.entity.SysOperLog;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 操作日志记录.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
public interface SysOperLogService extends IService<SysOperLog> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysOperLogAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysOperLogUptVo updateVo);

     /**
     * 根据主键批量删除数据.
     *
     * @param pks 主键
     */
    void batchDel(@NonNull Set<Long> pks);

    /**
     * 根据主键查询.
     *
     * @param operId 主键
     * @return 返回集合数据
     */
    SysOperLogDto getDetail(@NonNull Long operId);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysOperLogPageDto> queryPageByWrapper(@NonNull SysOperLogQueryVo queryVo);

}
