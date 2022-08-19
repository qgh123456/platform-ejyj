package com.atqgh.system.provider.controller;

import com.atqgh.common.utils.ResultObj;
import com.atqgh.system.provider.dto.SysDeptDto;
import com.atqgh.system.provider.service.SysDeptService;
import com.atqgh.system.provider.vo.SysDeptAddVo;
import com.atqgh.system.provider.vo.SysDeptUptVo;
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
 * 部门.
 *
 * @author Mubai
 * @date 2022-07-11 21:54:00
 */
@Api(tags = "部门")
@RestController
@RequestMapping("/sysDept")
public class SysDeptController {

    @Resource
    private SysDeptService sysDeptService;

    /**
     * 新增部门.
     *
     * @param addVo     新增部门参数
     * @return          新增成功
     */
    @ApiOperation(value = "新增部门", notes = "新增部门", produces = "application/json")
    @PostMapping("/add")
    public ResultObj add(@ApiParam("新增参数") @Valid @RequestBody SysDeptAddVo addVo) {

        this.sysDeptService.insert(addVo);
        return ResultObj.success("新增部门成功");
    }

    /**
     * 修改部门.
     *
     * @param updateVo  部门参数
     * @return string   修改是否成功提示信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改部门", notes = "修改部门", produces = "application/json")
    public ResultObj update(@ApiParam("修改参数") @Valid @RequestBody SysDeptUptVo updateVo) {

        this.sysDeptService.update(updateVo);
        return ResultObj.success("修改部门成功");
    }

    /**
     * 批量删除部门.
     *
     * @param pks 主键
     * @return 删除成功
     */
    @DeleteMapping("/batchDel/{pks}")
    @ApiOperation(value = "根据部门主键批量删除数据", notes = "根据部门主键批量删除数据", produces = "application/json")
    public ResultObj batchDel(@ApiParam("主键") @PathVariable(value = "pks") Set<Long> pks) {

        // 通过主键批量删除数据
        this.sysDeptService.batchDel(pks);
        return ResultObj.success("批量删除成功");
    }

    /**
    * 查看部门.
    *
    * @param deptId 主键
    * @return 详情信息
    */
    @GetMapping("/{deptId}")
    @ApiOperation(value = "根据deptId主键查看数据", notes = "根据deptId主键查看数据", produces = "application/json")
    public ResultObj getDetail(@PathVariable(value = "deptId") Long deptId) {

        // 通过主键查看数据
        SysDeptDto dto = this.sysDeptService.getDetail(deptId);
        return ResultObj.success(dto);
    }

}
