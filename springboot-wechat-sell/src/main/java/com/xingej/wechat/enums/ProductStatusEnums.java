package com.xingej.wechat.enums;

/**
 * 枚举 ：产品
 * 
 * @author erjun 2017年12月10日 上午5:34:18
 */
public enum ProductStatusEnums {

    UP(0, "上架"), DOWN(1, "下架");

    // 注意，这里提供了两个属性，以前都是一个属性，要注意下
    private Integer code;

    private String message;

    private ProductStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
