package com.supos.cloud.provider.model.dto.omc;

import com.supos.cloud.provider.model.vo.CartProductVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * The class Cart list query.
 *
 * @author walkman
 */
@Data
public class CartListQuery implements Serializable {
	private static final long serialVersionUID = -5968284112162772265L;
	private List<CartProductVo> cartProductVoList;
}
