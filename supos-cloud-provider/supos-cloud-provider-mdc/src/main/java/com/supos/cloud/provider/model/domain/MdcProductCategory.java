package com.supos.cloud.provider.model.domain;

import com.supos.cloud.core.mybatis.BaseEntity;
import com.supos.cloud.provider.model.enums.MdcCategoryStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * The class Mdc product category.
 *
 * @author walkman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "pc_mdc_product_category")
@Alias(value = "mdcProductCategory")
public class MdcProductCategory extends BaseEntity {

	private static final long serialVersionUID = 6966836239624795099L;

	/**
	 * 分类编码
	 */
	@Column(name = "category_code")
	private String categoryCode;

	/**
	 * 首图的流水号
	 */
	@Column(name = "img_id")
	private Long imgId;

	/**
	 * 父类别id当id=0时说明是根节点,一级类别
	 */
	private Long pid;

	/**
	 * 类别名称
	 */
	private String name;

	/**
	 * 类别状态1-启用,2-禁用
	 * {@link MdcCategoryStatusEnum}
	 */
	private Integer status;

	/**
	 * 排序编号,同类展示顺序,数值相等则自然排序
	 */
	@Column(name = "sort_order")
	private Integer sortOrder;

}