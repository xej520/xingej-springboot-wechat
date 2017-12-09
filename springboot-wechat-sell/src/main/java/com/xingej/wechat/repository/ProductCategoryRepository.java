package com.xingej.wechat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xingej.wechat.dataobject.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

}
