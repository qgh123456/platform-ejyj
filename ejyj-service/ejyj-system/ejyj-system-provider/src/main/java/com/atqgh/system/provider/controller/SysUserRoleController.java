package com.atqgh.system.provider.controller;

import com.atqgh.common.domain.ResultObj;
import com.atqgh.system.provider.dto.SysUserRoleDto;
import com.atqgh.system.provider.service.SysUserRoleService;
import com.atqgh.system.provider.vo.SysUserRoleAddVo;
import com.atqgh.system.provider.vo.SysUserRoleUptVo;
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
 * 用户和角色关联.
 *
 * @author Mubai
 * @date 2022-07-11 21:54:00
 */
@Api(tags = "用户和角色关联")
@RestController
@RequestMapping("/sysUserRole")
public class SysUserRoleController {

    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * 新增用户和角色关联.
     *
     * @param addVo     新增用户和角色关联参数
     * @return          新增成功
     */
    @ApiOperation(value = "新增用户和角色关联", notes = "新增用户和角色关联", produces = "application/json")
    @PostMapping("/add")
    public ResultObj<String> add(@ApiParam("新增参数") @Valid @RequestBody SysUserRoleAddVo addVo) {

        this.sysUserRoleService.insert(addVo);
        return ResultObj.success("新增用户和角色关联成功");
    }

    /**
     * 修改用户和角色关联.
     *
     * @param updateVo  用户和角色关联参数
     * @return string   修改是否成功提示信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改用户和角色关联", notes = "修改用户和角色关联", produces = "application/json")
    public ResultObj<String> update(@ApiParam("修改参数") @Valid @RequestBody SysUserRoleUptVo updateVo) {

        this.sysUserRoleService.update(updateVo);
        return ResultObj.success("修改用户和角色关联成功");
    }

    /**
     * 批量删除用户和角色关联.
     *
     * @param pks 主键
     * @return 删除成功
     */
    @DeleteMapping("/batchDel/{pks}")
    @ApiOperation(value = "根据用户和角色关联主键批量删除数据", notes = "根据用户和角色关联主键批量删除数据", produces = "application/json")
    public ResultObj<String> batchDel(@ApiParam("主键") @PathVariable(value = "pks") Set<String> pks) {

        // 通过主键批量删除数据
        this.sysUserRoleService.batchDel(pks);
        return ResultObj.success("批量删除成功");
    }

    /**
    * 查看用户和角色关联.
    *
    * @param userCode 主键
    * @return 详情信息
    */
    @GetMapping("/{userCode}")
    @ApiOperation(value = "根据userId主键查看数据", notes = "根据userId主键查看数据", produces = "application/json")
    public ResultObj<SysUserRoleDto> getDetail(@PathVariable(value = "userCode") String userCode) {

        // 通过主键查看数据
        SysUserRoleDto dto = this.sysUserRoleService.getDetail(userCode);
        return ResultObj.success(dto);
    }

}
