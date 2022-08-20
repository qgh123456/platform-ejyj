package com.atqgh.system.provider.controller;

import com.atqgh.common.domain.ResultObj;
import com.atqgh.system.provider.dto.SysPostDto;
import com.atqgh.system.provider.service.SysPostService;
import com.atqgh.system.provider.vo.SysPostAddVo;
import com.atqgh.system.provider.vo.SysPostUptVo;
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
 * 岗位信息.
 *
 * @author Mubai
 * @date 2022-07-11 21:54:00
 */
@Api(tags = "岗位信息")
@RestController
@RequestMapping("/sysPost")
public class SysPostController {

    @Resource
    private SysPostService sysPostService;

    /**
     * 新增岗位信息.
     *
     * @param addVo     新增岗位信息参数
     * @return          新增成功
     */
    @ApiOperation(value = "新增岗位信息", notes = "新增岗位信息", produces = "application/json")
    @PostMapping("/add")
    public ResultObj<String> add(@ApiParam("新增参数") @Valid @RequestBody SysPostAddVo addVo) {

        this.sysPostService.insert(addVo);
        return ResultObj.success("新增岗位信息成功");
    }

    /**
     * 修改岗位信息.
     *
     * @param updateVo  岗位信息参数
     * @return string   修改是否成功提示信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改岗位信息", notes = "修改岗位信息", produces = "application/json")
    public ResultObj<String> update(@ApiParam("修改参数") @Valid @RequestBody SysPostUptVo updateVo) {

        this.sysPostService.update(updateVo);
        return ResultObj.success("修改岗位信息成功");
    }

    /**
     * 批量删除岗位信息.
     *
     * @param pks 主键
     * @return 删除成功
     */
    @DeleteMapping("/batchDel/{pks}")
    @ApiOperation(value = "根据岗位信息主键批量删除数据", notes = "根据岗位信息主键批量删除数据", produces = "application/json")
    public ResultObj<String> batchDel(@ApiParam("主键") @PathVariable(value = "pks") Set<Long> pks) {

        // 通过主键批量删除数据
        this.sysPostService.batchDel(pks);
        return ResultObj.success("批量删除成功");
    }

    /**
    * 查看岗位信息.
    *
    * @param postId 主键
    * @return 详情信息
    */
    @GetMapping("/{postId}")
    @ApiOperation(value = "根据postId主键查看数据", notes = "根据postId主键查看数据", produces = "application/json")
    public ResultObj<SysPostDto> getDetail(@PathVariable(value = "postId") Long postId) {

        // 通过主键查看数据
        SysPostDto dto = this.sysPostService.getDetail(postId);
        return ResultObj.success(dto);
    }

}
