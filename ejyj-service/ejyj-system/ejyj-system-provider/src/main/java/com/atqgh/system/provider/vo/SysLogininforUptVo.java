package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 系统访问记录.
 * @author Mubai
 * @date 2022-08-14 10:45:23
 */
@ApiModel
@Data
public class SysLogininforUptVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("访问ID")
    @NotNull
    private Long id;

    @ApiModelProperty("用户账号")
    private String userName;

    @ApiModelProperty("登录IP地址")
    private String ipaddr;

    @ApiModelProperty("登录状态（0成功 1失败）")
    private String status;

    @ApiModelProperty("提示信息")
    private String msg;

    @ApiModelProperty("访问时间")
    private Date accessTime;

}
