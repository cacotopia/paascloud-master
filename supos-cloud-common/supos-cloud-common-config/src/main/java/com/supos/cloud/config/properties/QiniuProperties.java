package com.supos.cloud.config.properties;

import lombok.Data;

/**
 * The class Qiniu oss properties.
 *
 * @author walkman
 */
@Data
public class QiniuProperties {
	private QiniuKeyProperties key = new QiniuKeyProperties();
	private QiniuOssProperties oss = new QiniuOssProperties();

	@Data
	public class QiniuKeyProperties {
		private String accessKey;
		private String secretKey;
	}

	@Data
	public class QiniuOssProperties {
		private String privateHost;
		private String publicHost;
		private Long fileMaxSize;
	}
}
