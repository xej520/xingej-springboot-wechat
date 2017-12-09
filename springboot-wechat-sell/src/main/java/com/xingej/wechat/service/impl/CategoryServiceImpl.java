package com.xingej.wechat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xingej.wechat.dataobject.ProductCategory;
import com.xingej.wechat.repository.ProductCategoryRepository;
import com.xingej.wechat.service.CategoryService;

/**
 * 类目 服务层的实现
 * 
 * @author erjun 2017年12月9日 下午3:28:18
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findone(Integer catetoryId) {
        return repository.findOne(catetoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }

}
