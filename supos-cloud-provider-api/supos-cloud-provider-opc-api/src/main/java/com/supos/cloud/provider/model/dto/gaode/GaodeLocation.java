package com.supos.cloud.provider.model.dto.gaode;

import com.supos.cloud.base.dto.GaodeBaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The class Gaode location.
 *
 * @author walkman
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GaodeLocation extends GaodeBaseDto {
	private String province;
	private String city;
	private String adcode;
	private String rectangle;
}
