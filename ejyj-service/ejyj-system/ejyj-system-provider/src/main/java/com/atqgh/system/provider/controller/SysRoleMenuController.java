package com.atqgh.system.provider.controller;

import com.atqgh.common.domain.ResultObj;
import com.atqgh.system.provider.dto.SysRoleMenuDto;
import com.atqgh.system.provider.service.SysRoleMenuService;
import com.atqgh.system.provider.vo.SysRoleMenuAddVo;
import com.atqgh.system.provider.vo.SysRoleMenuUptVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Set;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色和菜单关联.
 *
 * @author Mubai
 * @date 2022-07-11 21:54:00
 */
@Api(tags = "角色和菜单关联")
@RestController
@RequestMapping("/sysRoleMenu")
public class SysRoleMenuController {

    @Resource
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 新增角色和菜单关联.
     *
     * @param addVo     新增角色和菜单关联参数
     * @return          新增成功
     */
    @ApiOperation(value = "新增角色和菜单关联", notes = "新增角色和菜单关联", produces = "application/json")
    @PostMapping("/add")
    public ResultObj<String> add(@ApiParam("新增参数") @Valid @RequestBody SysRoleMenuAddVo addVo) {

        this.sysRoleMenuService.insert(addVo);
        return ResultObj.success("新增角色和菜单关联成功");
    }

    /**
     * 修改角色和菜单关联.
     *
     * @param updateVo  角色和菜单关联参数
     * @return string   修改是否成功提示信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改角色和菜单关联", notes = "修改角色和菜单关联", produces = "application/json")
    public ResultObj<String> update(@ApiParam("修改参数") @Valid @RequestBody SysRoleMenuUptVo updateVo) {

        this.sysRoleMenuService.update(updateVo);
        return ResultObj.success("修改角色和菜单关联成功");
    }

    /**
     * 批量删除角色和菜单关联.
     *
     * @param pks 主键
     * @return 删除成功
     */
    @DeleteMapping("/batchDel/{pks}")
    @ApiOperation(value = "根据角色和菜单关联主键批量删除数据", notes = "根据角色和菜单关联主键批量删除数据", produces = "application/json")
    public ResultObj<String> batchDel(@ApiParam("主键") @PathVariable(value = "pks") Set<String> pks) {

        // 通过主键批量删除数据
        this.sysRoleMenuService.batchDel(pks);
        return ResultObj.success("批量删除成功");
    }

    /**
    * 查看角色和菜单关联.
    *
    * @param roleCode 主键
    * @return 详情信息
    */
    @GetMapping("/{roleCode}")
    @ApiOperation(value = "根据roleId主键查看数据", notes = "根据roleId主键查看数据", produces = "application/json")
    public ResultObj<SysRoleMenuDto> getDetail(@PathVariable(value = "roleId") String roleCode) {

        // 通过主键查看数据
        SysRoleMenuDto dto = this.sysRoleMenuService.getDetail(roleCode);
        return ResultObj.success(dto);
    }

}
