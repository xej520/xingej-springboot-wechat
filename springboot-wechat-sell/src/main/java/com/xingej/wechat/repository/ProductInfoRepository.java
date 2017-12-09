package com.xingej.wechat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xingej.wechat.dataobject.ProductInfo;

/**
 * JpaRepository<ProductInfo, String> 说明： ProductInfo 要操作的表对象
 * 
 * String 是 该表的主键类型是String
 * 
 * @author erjun 2017年12月9日 下午4:00:39
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    /**
     * 通过商品状态来查找
     * 
     * @param productStatus
     *            商品的状态
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
