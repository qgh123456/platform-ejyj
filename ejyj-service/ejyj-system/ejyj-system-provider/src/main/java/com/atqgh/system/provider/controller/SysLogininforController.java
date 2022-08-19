package com.atqgh.system.provider.controller;

import com.atqgh.common.utils.ResultObj;
import com.atqgh.system.provider.dto.SysLogininforDto;
import com.atqgh.system.provider.service.SysLogininforService;
import com.atqgh.system.provider.vo.SysLogininforAddVo;
import com.atqgh.system.provider.vo.SysLogininforUptVo;
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
 * 系统访问记.
 *
 * @author Mubai
 * @date 2022-07-11 21:53:59
 */
@Api(tags = "系统访问记")
@RestController
@RequestMapping("/sysLogininfor")
public class SysLogininforController {

    @Resource
    private SysLogininforService sysLogininforService;

    /**
     * 新增系统访问记.
     *
     * @param addVo     新增系统访问记参数
     * @return          新增成功
     */
    @ApiOperation(value = "新增系统访问记", notes = "新增系统访问记", produces = "application/json")
    @PostMapping("/add")
    public ResultObj add(@ApiParam("新增参数") @Valid @RequestBody SysLogininforAddVo addVo) {

        this.sysLogininforService.insert(addVo);
        return ResultObj.success("新增系统访问记成功");
    }

    /**
     * 修改系统访问记.
     *
     * @param updateVo  系统访问记参数
     * @return string   修改是否成功提示信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改系统访问记", notes = "修改系统访问记", produces = "application/json")
    public ResultObj update(@ApiParam("修改参数") @Valid @RequestBody SysLogininforUptVo updateVo) {

        this.sysLogininforService.update(updateVo);
        return ResultObj.success("修改系统访问记成功");
    }

    /**
     * 批量删除系统访问记.
     *
     * @param pks 主键
     * @return 删除成功
     */
    @DeleteMapping("/batchDel/{pks}")
    @ApiOperation(value = "根据系统访问记主键批量删除数据", notes = "根据系统访问记主键批量删除数据", produces = "application/json")
    public ResultObj batchDel(@ApiParam("主键") @PathVariable(value = "pks") Set<Long> pks) {

        // 通过主键批量删除数据
        this.sysLogininforService.batchDel(pks);
        return ResultObj.success("批量删除成功");
    }

    /**
    * 查看系统访问记.
    *
    * @param infoId 主键
    * @return 详情信息
    */
    @GetMapping("/{infoId}")
    @ApiOperation(value = "根据infoId主键查看数据", notes = "根据infoId主键查看数据", produces = "application/json")
    public ResultObj getDetail(@PathVariable(value = "infoId") Long infoId) {

        // 通过主键查看数据
        SysLogininforDto dto = this.sysLogininforService.getDetail(infoId);
        return ResultObj.success(dto);
    }

}
