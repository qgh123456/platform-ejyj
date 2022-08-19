package com.atqgh.system.provider.controller;

import com.atqgh.common.utils.ResultObj;
import com.atqgh.system.provider.dto.SysConfigDto;
import com.atqgh.system.provider.service.SysConfigService;
import com.atqgh.system.provider.vo.SysConfigAddVo;
import com.atqgh.system.provider.vo.SysConfigUptVo;
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
 * 参数配置.
 *
 * @author Mubai
 * @date 2022-07-11 21:53:59
 */
@Api(tags = "参数配置")
@RestController
@RequestMapping("/sysConfig")
public class SysConfigController {

    @Resource
    private SysConfigService sysConfigService;

    /**
     * 新增参数配置.
     *
     * @param addVo     新增参数配置参数
     * @return          新增成功
     */
    @ApiOperation(value = "新增参数配置", notes = "新增参数配置", produces = "application/json")
    @PostMapping("/add")
    public ResultObj add(@ApiParam("新增参数") @Valid @RequestBody SysConfigAddVo addVo) {

        this.sysConfigService.insert(addVo);
        return ResultObj.success("新增参数配置成功");
    }

    /**
     * 修改参数配置.
     *
     * @param updateVo  参数配置参数
     * @return string   修改是否成功提示信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改参数配置", notes = "修改参数配置", produces = "application/json")
    public ResultObj update(@ApiParam("修改参数") @Valid @RequestBody SysConfigUptVo updateVo) {

        this.sysConfigService.update(updateVo);
        return ResultObj.success("修改参数配置成功");
    }

    /**
     * 批量删除参数配置.
     *
     * @param pks 主键
     * @return 删除成功
     */
    @DeleteMapping("/batchDel/{pks}")
    @ApiOperation(value = "根据参数配置主键批量删除数据", notes = "根据参数配置主键批量删除数据", produces = "application/json")
    public ResultObj batchDel(@ApiParam("主键") @PathVariable(value = "pks") Set<Integer> pks) {

        // 通过主键批量删除数据
        this.sysConfigService.batchDel(pks);
        return ResultObj.success("批量删除成功");
    }

    /**
    * 查看参数配置.
    *
    * @param configId 主键
    * @return 详情信息
    */
    @GetMapping("/{configId}")
    @ApiOperation(value = "根据configId主键查看数据", notes = "根据configId主键查看数据", produces = "application/json")
    public ResultObj getDetail(@PathVariable(value = "configId") Integer configId) {

        // 通过主键查看数据
        SysConfigDto dto = this.sysConfigService.getDetail(configId);
        return ResultObj.success(dto);
    }

}
