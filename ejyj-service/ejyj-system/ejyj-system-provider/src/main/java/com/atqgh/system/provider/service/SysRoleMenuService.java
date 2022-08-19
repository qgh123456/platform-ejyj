package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysRoleMenuQueryVo;
import com.atqgh.system.provider.vo.SysRoleMenuAddVo;
import com.atqgh.system.provider.vo.SysRoleMenuUptVo;
import com.atqgh.system.provider.dto.SysRoleMenuDto;
import com.atqgh.system.provider.dto.SysRoleMenuPageDto;
import com.atqgh.system.provider.entity.SysRoleMenu;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 角色和菜单关联表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysRoleMenuAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysRoleMenuUptVo updateVo);

     /**
     * 根据主键批量删除数据.
     *
     * @param pks 主键
     */
    void batchDel(@NonNull Set<String> pks);

    /**
     * 根据主键查询.
     *
     * @param roleCode 主键
     * @return 返回集合数据
     */
    SysRoleMenuDto getDetail(@NonNull String roleCode);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysRoleMenuPageDto> queryPageByWrapper(@NonNull SysRoleMenuQueryVo queryVo);

}
