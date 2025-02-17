package com.supos.cloud.provider.model.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The class Ptc api constant.
 *
 * @author walkman
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PtcApiConstant {

    /**
     * The interface Alipay callback.
     *
     * @author walkman
     */
    public interface AlipayCallback {
        /**
         * The constant TRADE_STATUS_WAIT_BUYER_PAY.
         */
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        /**
         * The constant TRADE_STATUS_TRADE_SUCCESS.
         */
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        /**
         * The constant RESPONSE_SUCCESS.
         */
        String RESPONSE_SUCCESS = "success";
        /**
         * The constant RESPONSE_FAILED.
         */
        String RESPONSE_FAILED = "failed";
    }

    /**
     * The enum Pay platform enum.
     *
     * @author walkman
     */
    public enum PayPlatformEnum {
        /**
         * Alipay pay platform enum.
         */
        ALIPAY(1, "支付宝");

        PayPlatformEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;

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
