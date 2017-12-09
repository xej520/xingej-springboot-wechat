package com.xingej.wechat.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xingej.wechat.dataobject.ProductInfo;

/**
 * 商品 服务层接口
 * 
 * @author erjun 2017年12月10日 上午5:30:52
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /** 查询所有在架商品 */
    List<ProductInfo> findUpAll();

    // 分页查询
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

}
