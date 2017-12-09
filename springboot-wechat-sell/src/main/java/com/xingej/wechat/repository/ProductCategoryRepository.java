package com.xingej.wechat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xingej.wechat.dataobject.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    // 下面的写法是错误的，不支持List参数，
    // 方法名后，必须添加 In才可以的，
    // 这是JPA的规定
    List<ProductCategory> findByCategoryType(List<Integer> categoryTypeList);
}
