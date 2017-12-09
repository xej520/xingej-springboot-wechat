package com.xingej.wechat.service;

import java.util.List;

import com.xingej.wechat.dataobject.ProductCategory;

/**
 * 类目
 * 
 * @author erjun 2017年12月9日 下午3:24:42
 */
public interface CategoryService {
    ProductCategory findone(Integer catetoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
