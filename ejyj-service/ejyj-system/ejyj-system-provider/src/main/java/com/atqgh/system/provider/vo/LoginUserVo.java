package com.atqgh.system.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("密码")
    @NotNull(message = "密码名不能为空")
    private String password;

    @ApiModelProperty("验证码")
    @NotNull(message = "验证码不能为空")
    private String code;

    @ApiModelProperty("验证码对应的key")
    @NotNull(message = "key不能为空")
    private String key;

}
