package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysMenuQueryVo;
import com.atqgh.system.provider.vo.SysMenuAddVo;
import com.atqgh.system.provider.vo.SysMenuUptVo;
import com.atqgh.system.provider.dto.SysMenuDto;
import com.atqgh.system.provider.dto.SysMenuPageDto;
import com.atqgh.system.provider.entity.SysMenu;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 菜单权限表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysMenuAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysMenuUptVo updateVo);

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
    SysMenuDto getDetail(@NonNull Long id);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysMenuPageDto> queryPageByWrapper(@NonNull SysMenuQueryVo queryVo);

}
