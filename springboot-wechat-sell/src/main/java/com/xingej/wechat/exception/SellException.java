package com.xingej.wechat.exception;

import com.xingej.wechat.enums.ResultEnum;

/**
 * 自定义异常
 * 
 * @author erjun 2017年12月16日 下午12:51:05
 */
public class SellException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
