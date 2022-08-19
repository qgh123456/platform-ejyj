package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysLogininforQueryVo;
import com.atqgh.system.provider.vo.SysLogininforAddVo;
import com.atqgh.system.provider.vo.SysLogininforUptVo;
import com.atqgh.system.provider.dto.SysLogininforDto;
import com.atqgh.system.provider.dto.SysLogininforPageDto;
import com.atqgh.system.provider.entity.SysLogininfor;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 系统访问记录.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
public interface SysLogininforService extends IService<SysLogininfor> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysLogininforAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysLogininforUptVo updateVo);

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
    SysLogininforDto getDetail(@NonNull Long id);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysLogininforPageDto> queryPageByWrapper(@NonNull SysLogininforQueryVo queryVo);

}
