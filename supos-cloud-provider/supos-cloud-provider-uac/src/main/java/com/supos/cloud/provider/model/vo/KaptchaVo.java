package com.supos.cloud.provider.model.vo;

import io.swagger.annotations.Api;
import lombok.Data;

/**
 * The class Kaptcha vo.
 *
 * @author walkman
 */
@Data
@Api
public class KaptchaVo {
	private String cookieCode;
	private String base64Code;
	private String kaptchaCode;
}
