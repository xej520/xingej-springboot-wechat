package com.xingej.wechat.vo;

/**
 * http请求返回给最外层的对象，
 * 
 * 就是返回给页面的请求对象
 * 
 * @author erjun 2017年12月10日 上午6:17:14
 */
/**
 * 泛型类
 * 
 * @author erjun 2017年12月10日 上午6:19:18
 * @param <T>
 */
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String messge;

    /** 具体内容. */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVO [code=" + code + ", messge=" + messge + ", data=" + data + "]";
    }

}
