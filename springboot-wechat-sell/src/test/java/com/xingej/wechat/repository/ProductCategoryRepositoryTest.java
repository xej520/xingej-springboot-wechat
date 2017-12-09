package com.xingej.wechat.repository;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
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

    @Test
    public void testFindone() {

        ProductCategory findOne = pcRepository.findOne(2);

        System.out.println("--->:\t" + findOne.toString());

    }

    // 注意，这里使用的findByCategoryTypeIn
    // 支持一次性查询多个
    @Test
    public void testFindByCategoryTypeIn() {
        List<Integer> categoryTypeList = Arrays.asList(1, 2);

        List<ProductCategory> result = pcRepository.findByCategoryType(categoryTypeList);

        // 进行断言，期望的跟 实际的是否相等呢
        Assert.assertEquals(2, result.size());

    }

}
