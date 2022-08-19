package com.atqgh.system.provider.service;

import com.atqgh.system.provider.vo.SysDeptQueryVo;
import com.atqgh.system.provider.vo.SysDeptAddVo;
import com.atqgh.system.provider.vo.SysDeptUptVo;
import com.atqgh.system.provider.dto.SysDeptDto;
import com.atqgh.system.provider.dto.SysDeptPageDto;
import com.atqgh.system.provider.entity.SysDept;
import java.util.Set;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.NonNull;

/**
 * 部门表.
 *
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
public interface SysDeptService extends IService<SysDept> {

    /**
     * 新增.
     *
     * @param addVo 保存参数
     * @return 返回数据
     */
    int insert(@NonNull SysDeptAddVo addVo);

    /**
     * 修改.
     *
     * @param updateVo 修改参数
     * @return 返回数据
     */
    int update(@NonNull SysDeptUptVo updateVo);

     /**
     * 根据主键批量删除数据.
     *
     * @param pks 主键
     */
    void batchDel(@NonNull Set<Long> pks);

    /**
     * 根据主键查询.
     *SysDeptServiceImpl.java
     * SysUserServiceImpl.java
     * SysPostServiceImpl.java
     * SysRoleServiceImpl.java
     * SysMenuServiceImpl.java
     * SysUserRoleServiceImpl.java
     * SysRoleMenuServiceImpl.java
     * SysRoleDeptServiceImpl.java
     * SysUserPostServiceImpl.java
     * SysOperLogServiceImpl.java
     * SysDictTypeServiceImpl.java
     * SysDictDataServiceImpl.java
     * SysConfigServiceImpl.java
     * SysLogininforServiceImpl.java
     * SysJobServiceImpl.java
     * SysJobLogServiceImpl.java
     * SysNoticeServiceImpl.java
     * @param id 主键
     * @return 返回集合数据
     */
    SysDeptDto getDetail(@NonNull Long id);

    /**
     * 分页查询.
     *
     * @param queryVo 查询参数
     * @return 返回集合数据
     */
    PageInfo<SysDeptPageDto> queryPageByWrapper(@NonNull SysDeptQueryVo queryVo);

}
