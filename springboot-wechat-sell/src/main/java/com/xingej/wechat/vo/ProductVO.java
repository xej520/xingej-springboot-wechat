package com.xingej.wechat.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductVO {

    // 我本地称为categoryName
    // 返回给页面时，称为name
    // @JsonProperty 起别名的意思，就是类似于@Column(name ="")
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductInfoVO> getProductInfoVOList() {
        return productInfoVOList;
    }

    public void setProductInfoVOList(List<ProductInfoVO> productInfoVOList) {
        this.productInfoVOList = productInfoVOList;
    }

}
