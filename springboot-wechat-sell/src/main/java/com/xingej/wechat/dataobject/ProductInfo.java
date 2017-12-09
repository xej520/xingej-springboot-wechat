package com.xingej.wechat.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * 产品/商品信息表
 * 
 * @author erjun 2017年12月9日 下午3:54:58
 */
@Entity // 实体类对象与数据表进行映射
// 不提倡使用下面的注解，因为一个团队里，你添加lombok插件(此插件，并非必须的)，其他成员可能没有添加这些插件
// 运行项目时，就会报错的。
// @Data
// @DynamicUpdate
public class ProductInfo {

    // 作为主键
    @Id
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @GeneratedValue(generator = "uuidGenerator")
    private String productId;

    /** 产品名称 */
    private String productName;

    /** 产品单价 */
    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    @Column(name = "`product_icon`", length = 255)
    private String productIcon;

    /**
     * 状态, 0正常1下架.
     */
    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ProductInfo [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
                + ", productStock=" + productStock + ", productDescription=" + productDescription + ", productIcon="
                + productIcon + ", productStatus=" + productStatus + ", categoryType=" + categoryType + ", createTime="
                + createTime + ", updateTime=" + updateTime + "]";
    }

}
