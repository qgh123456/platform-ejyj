package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysPostQueryVo;
import com.atqgh.system.provider.vo.SysPostAddVo;
import com.atqgh.system.provider.vo.SysPostUptVo;
import com.atqgh.system.provider.dto.SysPostDto;
import com.atqgh.system.provider.dto.SysPostPageDto;
import com.atqgh.system.provider.entity.SysPost;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 岗位信息表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
public interface SysPostService extends IService<SysPost> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysPostAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysPostUptVo updateVo);

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
    SysPostDto getDetail(@NonNull Long id);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysPostPageDto> queryPageByWrapper(@NonNull SysPostQueryVo queryVo);

}
