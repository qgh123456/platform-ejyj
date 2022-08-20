package com.atqgh.system.provider.controller;

import com.atqgh.common.domain.ResultObj;
import com.atqgh.system.provider.dto.SysDictTypeDto;
import com.atqgh.system.provider.service.SysDictTypeService;
import com.atqgh.system.provider.vo.SysDictTypeAddVo;
import com.atqgh.system.provider.vo.SysDictTypeUptVo;
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
 * 字典类型.
 *
 * @author Mubai
 * @date 2022-07-11 21:54:00
 */
@Api(tags = "字典类型")
@RestController
@RequestMapping("/sysDictType")
public class SysDictTypeController {

    @Resource
    private SysDictTypeService sysDictTypeService;

    /**
     * 新增字典类型.
     *
     * @param addVo     新增字典类型参数
     * @return          新增成功
     */
    @ApiOperation(value = "新增字典类型", notes = "新增字典类型", produces = "application/json")
    @PostMapping("/add")
    public ResultObj<String> add(@ApiParam("新增参数") @Valid @RequestBody SysDictTypeAddVo addVo) {

        this.sysDictTypeService.insert(addVo);
        return ResultObj.success("新增字典类型成功");
    }

    /**
     * 修改字典类型.
     *
     * @param updateVo  字典类型参数
     * @return string   修改是否成功提示信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改字典类型", notes = "修改字典类型", produces = "application/json")
    public ResultObj<String> update(@ApiParam("修改参数") @Valid @RequestBody SysDictTypeUptVo updateVo) {

        this.sysDictTypeService.update(updateVo);
        return ResultObj.success("修改字典类型成功");
    }

    /**
     * 批量删除字典类型.
     *
     * @param pks 主键
     * @return 删除成功
     */
    @DeleteMapping("/batchDel/{pks}")
    @ApiOperation(value = "根据字典类型主键批量删除数据", notes = "根据字典类型主键批量删除数据", produces = "application/json")
    public ResultObj<String> batchDel(@ApiParam("主键") @PathVariable(value = "pks") Set<String> pks) {

        // 通过主键批量删除数据
        this.sysDictTypeService.batchDel(pks);
        return ResultObj.success("批量删除成功");
    }

    /**
    * 查看字典类型.
    *
    * @param dictType 主键
    * @return 详情信息
    */
    @GetMapping("/{dictType}")
    @ApiOperation(value = "根据dictType主键查看数据", notes = "根据dictType主键查看数据", produces = "application/json")
    public ResultObj<SysDictTypeDto> getDetail(@PathVariable(value = "dictType") String dictType) {

        // 通过主键查看数据
        SysDictTypeDto dto = this.sysDictTypeService.getDetail(dictType);
        return ResultObj.success(dto);
    }

}
