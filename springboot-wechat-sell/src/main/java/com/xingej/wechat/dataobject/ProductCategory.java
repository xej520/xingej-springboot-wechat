package com.xingej.wechat.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 类目表
 * 
 * @author erjun 2017年12月9日 下午1:48:47
 */

@Entity // 将数据库映射成java 对象
@DynamicUpdate // 这个注解的作用，就是，更新时间自动变化
// 我现在的本地环境是失败的，由于，数据库的版本比较低，5.5的，好像得5.6以上，数据库才能支持自动更新时间戳
public class ProductCategory {

    // 类目ID
    @Id
    @GeneratedValue // id采用 自增形式
    private Integer categoryId;

    // 类目名称
    private String categoryName;

    // 类目编号
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

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
        return "ProductCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryType="
                + categoryType + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
    }

}
