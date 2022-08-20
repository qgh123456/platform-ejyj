package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 登陆的实体类.
 *
 * @author Mubai
 * @since 2022/8/20 5:00 下午
 **/
@Data
@ApiModel("登陆的实体类")
public class LoginUserVo implements Serializable {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

}
