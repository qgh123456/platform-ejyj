package com.atqgh.system.provider.controller;

import com.atqgh.common.core.domain.ResultObj;
import com.atqgh.system.provider.dto.SysNoticeDto;
import com.atqgh.system.provider.service.SysNoticeService;
import com.atqgh.system.provider.vo.SysNoticeAddVo;
import com.atqgh.system.provider.vo.SysNoticeUptVo;
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
 * 通知公告.
 *
 * @author Mubai
 * @date 2022-07-11 21:54:00
 */
@Api(tags = "通知公告")
@RestController
@RequestMapping("/sysNotice")
public class SysNoticeController {

    @Resource
    private SysNoticeService sysNoticeService;

    /**
     * 新增通知公告.
     *
     * @param addVo     新增通知公告参数
     * @return          新增成功
     */
    @ApiOperation(value = "新增通知公告", notes = "新增通知公告", produces = "application/json")
    @PostMapping("/add")
    public ResultObj<String> add(@ApiParam("新增参数") @Valid @RequestBody SysNoticeAddVo addVo) {

        this.sysNoticeService.insert(addVo);
        return ResultObj.success("新增通知公告成功");
    }

    /**
     * 修改通知公告.
     *
     * @param updateVo  通知公告参数
     * @return string   修改是否成功提示信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改通知公告", notes = "修改通知公告", produces = "application/json")
    public ResultObj<String> update(@ApiParam("修改参数") @Valid @RequestBody SysNoticeUptVo updateVo) {

        this.sysNoticeService.update(updateVo);
        return ResultObj.success("修改通知公告成功");
    }

    /**
     * 批量删除通知公告.
     *
     * @param pks 主键
     * @return 删除成功
     */
    @DeleteMapping("/batchDel/{pks}")
    @ApiOperation(value = "根据通知公告主键批量删除数据", notes = "根据通知公告主键批量删除数据", produces = "application/json")
    public ResultObj<String> batchDel(@ApiParam("主键") @PathVariable(value = "pks") Set<Integer> pks) {

        // 通过主键批量删除数据
        this.sysNoticeService.batchDel(pks);
        return ResultObj.success("批量删除成功");
    }

    /**
    * 查看通知公告.
    *
    * @param noticeId 主键
    * @return 详情信息
    */
    @GetMapping("/{noticeId}")
    @ApiOperation(value = "根据noticeId主键查看数据", notes = "根据noticeId主键查看数据", produces = "application/json")
    public ResultObj<SysNoticeDto> getDetail(@PathVariable(value = "noticeId") Integer noticeId) {

        // 通过主键查看数据
        SysNoticeDto dto = this.sysNoticeService.getDetail(noticeId);
        return ResultObj.success(dto);
    }

}
