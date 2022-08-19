package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysUserRoleQueryVo;
import com.atqgh.system.provider.vo.SysUserRoleAddVo;
import com.atqgh.system.provider.vo.SysUserRoleUptVo;
import com.atqgh.system.provider.dto.SysUserRoleDto;
import com.atqgh.system.provider.dto.SysUserRolePageDto;
import com.atqgh.system.provider.entity.SysUserRole;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 用户和角色关联表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysUserRoleAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysUserRoleUptVo updateVo);

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
    SysUserRoleDto getDetail(@NonNull String userCode);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysUserRolePageDto> queryPageByWrapper(@NonNull SysUserRoleQueryVo queryVo);

}
