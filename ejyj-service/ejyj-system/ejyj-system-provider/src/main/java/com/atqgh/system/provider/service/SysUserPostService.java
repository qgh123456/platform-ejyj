package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysUserPostQueryVo;
import com.atqgh.system.provider.vo.SysUserPostAddVo;
import com.atqgh.system.provider.vo.SysUserPostUptVo;
import com.atqgh.system.provider.dto.SysUserPostDto;
import com.atqgh.system.provider.dto.SysUserPostPageDto;
import com.atqgh.system.provider.entity.SysUserPost;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 用户与岗位关联表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
public interface SysUserPostService extends IService<SysUserPost> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysUserPostAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysUserPostUptVo updateVo);

     /**
     * 根据主键批量删除数据.
     *
     * @param pks 主键
     */
    void batchDel(@NonNull Set<String> pks);

    /**
     * 根据主键查询.
     *
     * @param userCode 主键
     * @return 返回集合数据
     */
    SysUserPostDto getDetail(@NonNull String userCode);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysUserPostPageDto> queryPageByWrapper(@NonNull SysUserPostQueryVo queryVo);

}
