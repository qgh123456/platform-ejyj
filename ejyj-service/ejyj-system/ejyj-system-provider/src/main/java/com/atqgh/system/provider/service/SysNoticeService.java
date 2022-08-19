package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysNoticeQueryVo;
import com.atqgh.system.provider.vo.SysNoticeAddVo;
import com.atqgh.system.provider.vo.SysNoticeUptVo;
import com.atqgh.system.provider.dto.SysNoticeDto;
import com.atqgh.system.provider.dto.SysNoticePageDto;
import com.atqgh.system.provider.entity.SysNotice;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 通知公告表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
public interface SysNoticeService extends IService<SysNotice> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysNoticeAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysNoticeUptVo updateVo);

     /**
     * 根据主键批量删除数据.
     *
     * @param pks 主键
     */
    void batchDel(@NonNull Set<Integer> pks);

    /**
     * 根据主键查询.
     *
     * @param id 主键
     * @return 返回集合数据
     */
    SysNoticeDto getDetail(@NonNull Integer id);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysNoticePageDto> queryPageByWrapper(@NonNull SysNoticeQueryVo queryVo);

}
