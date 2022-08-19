package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysUserQueryVo;
import com.atqgh.system.provider.vo.SysUserAddVo;
import com.atqgh.system.provider.vo.SysUserUptVo;
import com.atqgh.system.provider.dto.SysUserDto;
import com.atqgh.system.provider.dto.SysUserPageDto;
import com.atqgh.system.provider.entity.SysUser;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 用户信息表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysUserAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysUserUptVo updateVo);

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
    SysUserDto getDetail(@NonNull Long id);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysUserPageDto> queryPageByWrapper(@NonNull SysUserQueryVo queryVo);

}
