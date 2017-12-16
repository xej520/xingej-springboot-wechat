package com.xingej.wechat.enums;

/**
 * 
 * 支付状态
 * 
 * @author erjun 2017年12月16日 上午10:02:40
 */
public enum PayStatusEnum {
    WAIT(0, "等待支付"), SUCCESS(1, "支付成功");

    private int code;

    private String message;

    private PayStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
