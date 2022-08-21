package com.atqgh.system.provider.controller;

import com.atqgh.common.core.domain.ResultObj;
import com.atqgh.system.provider.dto.SysJobLogDto;
import com.atqgh.system.provider.service.SysJobLogService;
import com.atqgh.system.provider.vo.SysJobLogAddVo;
import com.atqgh.system.provider.vo.SysJobLogUptVo;
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
 * 定时任务调度日志.
 *
 * @author Mubai
 * @date 2022-07-11 21:53:59
 */
@Api(tags = "定时任务调度日志")
@RestController
@RequestMapping("/sysJobLog")
public class SysJobLogController {

    @Resource
    private SysJobLogService sysJobLogService;

    /**
     * 新增定时任务调度日志.
     *
     * @param addVo     新增定时任务调度日志参数
     * @return          新增成功
     */
    @ApiOperation(value = "新增定时任务调度日志", notes = "新增定时任务调度日志", produces = "application/json")
    @PostMapping("/add")
    public ResultObj<String> add(@ApiParam("新增参数") @Valid @RequestBody SysJobLogAddVo addVo) {

        this.sysJobLogService.insert(addVo);
        return ResultObj.success("新增定时任务调度日志成功");
    }

    /**
     * 修改定时任务调度日志.
     *
     * @param updateVo  定时任务调度日志参数
     * @return string   修改是否成功提示信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改定时任务调度日志", notes = "修改定时任务调度日志", produces = "application/json")
    public ResultObj<String> update(@ApiParam("修改参数") @Valid @RequestBody SysJobLogUptVo updateVo) {

        this.sysJobLogService.update(updateVo);
        return ResultObj.success("修改定时任务调度日志成功");
    }

    /**
     * 批量删除定时任务调度日志.
     *
     * @param pks 主键
     * @return 删除成功
     */
    @DeleteMapping("/batchDel/{pks}")
    @ApiOperation(value = "根据定时任务调度日志主键批量删除数据", notes = "根据定时任务调度日志主键批量删除数据", produces = "application/json")
    public ResultObj<String> batchDel(@ApiParam("主键") @PathVariable(value = "pks") Set<Long> pks) {

        // 通过主键批量删除数据
        this.sysJobLogService.batchDel(pks);
        return ResultObj.success("批量删除成功");
    }

    /**
    * 查看定时任务调度日志.
    *
    * @param jobLogId 主键
    * @return 详情信息
    */
    @GetMapping("/{jobLogId}")
    @ApiOperation(value = "根据jobLogId主键查看数据", notes = "根据jobLogId主键查看数据", produces = "application/json")
    public ResultObj<SysJobLogDto> getDetail(@PathVariable(value = "jobLogId") Long jobLogId) {

        // 通过主键查看数据
        SysJobLogDto dto = this.sysJobLogService.getDetail(jobLogId);
        return ResultObj.success(dto);
    }

}
