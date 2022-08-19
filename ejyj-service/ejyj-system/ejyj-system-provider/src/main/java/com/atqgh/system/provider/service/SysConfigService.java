package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysConfigQueryVo;
import com.atqgh.system.provider.vo.SysConfigAddVo;
import com.atqgh.system.provider.vo.SysConfigUptVo;
import com.atqgh.system.provider.dto.SysConfigDto;
import com.atqgh.system.provider.dto.SysConfigPageDto;
import com.atqgh.system.provider.entity.SysConfig;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 参数配置表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
public interface SysConfigService extends IService<SysConfig> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysConfigAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysConfigUptVo updateVo);

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
    SysConfigDto getDetail(@NonNull Integer id);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysConfigPageDto> queryPageByWrapper(@NonNull SysConfigQueryVo queryVo);

}
