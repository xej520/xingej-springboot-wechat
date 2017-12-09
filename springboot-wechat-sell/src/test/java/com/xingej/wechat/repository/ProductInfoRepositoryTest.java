package com.xingej.wechat.repository;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xingej.wechat.BaseTest;
import com.xingej.wechat.dataobject.ProductInfo;

public class ProductInfoRepositoryTest extends BaseTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void testSave() {
        ProductInfo productInfo = new ProductInfo();

        productInfo.setProductId("123123456456");
        productInfo.setProductName("milk");
        productInfo.setProductPrice(new BigDecimal(5.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("good milk");
        productInfo.setProductIcon("http://aa.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo save = productInfoRepository.save(productInfo);

        System.out.println("----save---:\t" + save.toString());

    }

    @Test
    public void testFindByProductStatus() {
        List<ProductInfo> findByProductStatus = productInfoRepository.findByProductStatus(0);

        System.out.println("----size----:\t" + findByProductStatus.size());
    }

}
