package com.xingej.wechat.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xingej.wechat.BaseTest;
import com.xingej.wechat.dataobject.ProductCategory;

public class ProductCategoryRepositoryTest extends BaseTest {

    @Autowired
    private ProductCategoryRepository pcRepository;

    // 测试插入数据
    @Test
    public void testSave() {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("计算机基础框架");
        productCategory.setCategoryType(2);

        pcRepository.saveAndFlush(productCategory);

    }

}
