package com.supos.cloud.provider.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The class Order detail dto.
 *
 * @author walkman
 */
@Data
public class OrderDetailDto implements Serializable {

    private static final long serialVersionUID = 4423448618530228839L;

    private Long id;

    /**
     * 订单明细序列号
     */
    private String detailNo;

    private Long userId;

    private String orderNo;

    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品图片地址
     */
    private String productImage;

    /**
     * 生成订单时的商品单价, 单位是元,保留两位小数
     */
    private BigDecimal currentUnitPrice;

    /**
     * 商品数量
     */
    private Integer quantity;

    /**
     * 商品总价,单位是元,保留两位小数
     */
    private BigDecimal totalPrice;
}
