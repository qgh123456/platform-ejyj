package com.atqgh.system.provider.controller;

import com.atqgh.common.domain.ResultObj;
import com.atqgh.system.provider.dto.SysOperLogDto;
import com.atqgh.system.provider.service.SysOperLogService;
import com.atqgh.system.provider.vo.SysOperLogAddVo;
import com.atqgh.system.provider.vo.SysOperLogUptVo;
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
 * 操作日志记.
 *
 * @author Mubai
 * @date 2022-07-11 21:54:00
 */
@Api(tags = "操作日志记")
@RestController
@RequestMapping("/sysOperLog")
public class SysOperLogController {

    @Resource
    private SysOperLogService sysOperLogService;

    /**
     * 新增操作日志记.
     *
     * @param addVo     新增操作日志记参数
     * @return          新增成功
     */
    @ApiOperation(value = "新增操作日志记", notes = "新增操作日志记", produces = "application/json")
    @PostMapping("/add")
    public ResultObj<String> add(@ApiParam("新增参数") @Valid @RequestBody SysOperLogAddVo addVo) {

        this.sysOperLogService.insert(addVo);
        return ResultObj.success("新增操作日志记成功");
    }

    /**
     * 修改操作日志记.
     *
     * @param updateVo  操作日志记参数
     * @return string   修改是否成功提示信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改操作日志记", notes = "修改操作日志记", produces = "application/json")
    public ResultObj<String> update(@ApiParam("修改参数") @Valid @RequestBody SysOperLogUptVo updateVo) {

        this.sysOperLogService.update(updateVo);
        return ResultObj.success("修改操作日志记成功");
    }

    /**
     * 批量删除操作日志记.
     *
     * @param pks 主键
     * @return 删除成功
     */
    @DeleteMapping("/batchDel/{pks}")
    @ApiOperation(value = "根据操作日志记主键批量删除数据", notes = "根据操作日志记主键批量删除数据", produces = "application/json")
    public ResultObj<String> batchDel(@ApiParam("主键") @PathVariable(value = "pks") Set<Long> pks) {

        // 通过主键批量删除数据
        this.sysOperLogService.batchDel(pks);
        return ResultObj.success("批量删除成功");
    }

    /**
    * 查看操作日志记.
    *
    * @param operId 主键
    * @return 详情信息
    */
    @GetMapping("/{operId}")
    @ApiOperation(value = "根据operId主键查看数据", notes = "根据operId主键查看数据", produces = "application/json")
    public ResultObj<SysOperLogDto> getDetail(@PathVariable(value = "operId") Long operId) {

        // 通过主键查看数据
        SysOperLogDto dto = this.sysOperLogService.getDetail(operId);
        return ResultObj.success(dto);
    }

}
