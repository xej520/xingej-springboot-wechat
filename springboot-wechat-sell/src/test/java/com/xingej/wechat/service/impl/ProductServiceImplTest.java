package com.xingej.wechat.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.xingej.wechat.BaseTest;
import com.xingej.wechat.dataobject.ProductInfo;
import com.xingej.wechat.repository.ProductInfoRepository;

public class ProductServiceImplTest extends BaseTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void testFindone() {
        ProductInfo productInfo = productInfoRepository.findOne("402881e5603aeb5b01603aeb64930000");
        Assert.assertEquals("402881e5603aeb5b01603aeb64930000", productInfo.getProductId());
    }

    @Test
    public void testSave() {
        PageRequest request = new PageRequest(0, 2);

        Page<ProductInfo> productInfoPage = productInfoRepository.findAll(request);

        System.out.println(productInfoPage.getTotalElements());

    }

}
