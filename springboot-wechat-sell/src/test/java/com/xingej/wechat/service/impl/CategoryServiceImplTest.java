package com.xingej.wechat.service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xingej.wechat.BaseTest;
import com.xingej.wechat.dataobject.ProductCategory;
import com.xingej.wechat.service.CategoryService;

public class CategoryServiceImplTest extends BaseTest {

    /**
     * 注意:注入接口或者改接口的实现类，都是可以的CategoryServiceImpl 或者CategoryService
     * 
     */
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testFindone() {
        ProductCategory findone = categoryService.findone(1);

        System.out.println("--->:\t" + findone.toString());
    }

    @Test
    public void testFindone2() {
        ProductCategory findone = categoryServiceImpl.findone(1);

        System.out.println("--->:\t" + findone.toString());
    }

    @Test
    public void testFindAll() {
        List<ProductCategory> findAll = categoryService.findAll();

        for (ProductCategory key : findAll) {
            System.out.println("--->:\t" + key.toString());
        }
    }

    @Test
    public void testSave() {
        ProductCategory productCategory = new ProductCategory();

        productCategory.setCategoryName("spark");
        productCategory.setCategoryType(3);
        productCategory.setCreateTime(new Date());
        productCategory.setUpdateTime(new Date());

        categoryService.save(productCategory);
    }

}
