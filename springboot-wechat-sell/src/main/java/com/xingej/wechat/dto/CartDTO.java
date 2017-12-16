package com.xingej.wechat.dto;

/**
 * 
 * @author erjun 2017年12月16日 下午12:38:23
 */
public class CartDTO {
    private String productId;

    // 数量
    private Integer productQuantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
