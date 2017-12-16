package com.xingej.wechat.enums;

/**
 * 
 * 订单的状态
 * 
 * @author erjun 2017年12月16日 上午10:02:40
 */
public enum OrderStatusEnum {
    NEW(0, "新订单"), FINISHED(1, "完结"), cancel(2, "已取消");

    private int code;

    private String message;

    private OrderStatusEnum(int code, String message) {
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
