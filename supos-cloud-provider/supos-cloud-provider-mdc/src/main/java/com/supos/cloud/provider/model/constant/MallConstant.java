package com.supos.cloud.provider.model.constant;

/**
 * The class Mall constant.
 *
 * @author walkman
 */
public class MallConstant {
	/**
	 * The enum Product status enum.
	 *
	 * @author walkman
	 */
	public enum ProductStatusEnum {
		/**
		 * On sale product status enum.
		 */
		ON_SALE(1, "在线");
		private String value;
		private int code;

		ProductStatusEnum(int code, String value) {
			this.code = code;
			this.value = value;
		}

		/**
		 * Gets value.
		 *
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * Gets code.
		 *
		 * @return the code
		 */
		public int getCode() {
			return code;
		}
	}
}
