package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 操作日志记录.
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@ApiModel
@Data
public class SysOperLogUptVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志主键")
    @NotNull
    private Long operId;

    @ApiModelProperty("模块标题")
    private String title;

    @ApiModelProperty("业务类型（0其它 1新增 2修改 3删除）")
    private Integer businessType;

    @ApiModelProperty("方法名称")
    private String method;

    @ApiModelProperty("请求方式")
    private String requestMethod;

    @ApiModelProperty("操作类别（0其它 1后台用户 2手机端用户）")
    private Integer operatorType;

    @ApiModelProperty("操作人员")
    private String operName;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("请求URL")
    private String operUrl;

    @ApiModelProperty("主机地址")
    private String operIp;

    @ApiModelProperty("操作地点")
    private String operLocation;

    @ApiModelProperty("请求参数")
    private String operParam;

    @ApiModelProperty("返回参数")
    private String jsonResult;

    @ApiModelProperty("操作状态（0正常 1异常）")
    private Integer status;

    @ApiModelProperty("错误消息")
    private String errorMsg;

    @ApiModelProperty("操作时间")
    private Date operTime;

}
