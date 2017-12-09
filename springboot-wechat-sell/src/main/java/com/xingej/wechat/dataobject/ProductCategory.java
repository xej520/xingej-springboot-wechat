package com.xingej.wechat.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 类目表
 * 
 * @author erjun 2017年12月9日 下午1:48:47
 */

@Entity // 将数据库映射成java 对象
public class ProductCategory {

    // 类目ID
    @Id
    @GeneratedValue // id采用 自增形式
    private Integer categoryId;

    // 类目名称
    private String categoryName;

    // 类目编号
    private Integer categoryType;

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

}
