package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysDictDataQueryVo;
import com.atqgh.system.provider.vo.SysDictDataAddVo;
import com.atqgh.system.provider.vo.SysDictDataUptVo;
import com.atqgh.system.provider.dto.SysDictDataDto;
import com.atqgh.system.provider.dto.SysDictDataPageDto;
import com.atqgh.system.provider.entity.SysDictData;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 字典数据表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
public interface SysDictDataService extends IService<SysDictData> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysDictDataAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysDictDataUptVo updateVo);

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
    SysDictDataDto getDetail(@NonNull Long id);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysDictDataPageDto> queryPageByWrapper(@NonNull SysDictDataQueryVo queryVo);

}
