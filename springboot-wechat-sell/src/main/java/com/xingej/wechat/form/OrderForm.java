package com.xingej.wechat.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 订单 表单验证
 * 
 * @author erjun 2017年12月17日 上午10:51:57
 */
// 这些字段，都是controller层里 传入的参数
// 将这些参数，都封装再一个类里，
// 这样的话，只需要处理这个对象即可了。
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "买家地址必填")
    private String address;

    @NotEmpty(message = "opendid必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

}
