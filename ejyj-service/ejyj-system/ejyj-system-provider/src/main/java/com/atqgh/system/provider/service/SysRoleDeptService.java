package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysRoleDeptQueryVo;
import com.atqgh.system.provider.vo.SysRoleDeptAddVo;
import com.atqgh.system.provider.vo.SysRoleDeptUptVo;
import com.atqgh.system.provider.dto.SysRoleDeptDto;
import com.atqgh.system.provider.dto.SysRoleDeptPageDto;
import com.atqgh.system.provider.entity.SysRoleDept;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 角色和部门关联表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
public interface SysRoleDeptService extends IService<SysRoleDept> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysRoleDeptAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysRoleDeptUptVo updateVo);

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
    SysRoleDeptDto getDetail(@NonNull String roleCode);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysRoleDeptPageDto> queryPageByWrapper(@NonNull SysRoleDeptQueryVo queryVo);

}
