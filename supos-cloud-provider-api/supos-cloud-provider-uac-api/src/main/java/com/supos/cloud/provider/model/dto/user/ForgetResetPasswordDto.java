package com.supos.cloud.provider.model.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 忘记密码.
 *
 * @author walkman
 */
@Data
@ApiModel
public class ForgetResetPasswordDto implements Serializable {
    private static final long serialVersionUID = 5478700873789068921L;
    @ApiModelProperty(value = "登录名")
    private String loginName;
    @ApiModelProperty(value = "密码")
    private String loginPwd;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "验证码")
    private String emailCode;
    @ApiModelProperty(value = "token")
    private String forgetToken;
}
