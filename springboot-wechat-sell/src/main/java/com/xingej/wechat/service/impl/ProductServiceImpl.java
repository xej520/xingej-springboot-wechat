package com.xingej.wechat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xingej.wechat.dataobject.ProductInfo;
import com.xingej.wechat.dto.CartDTO;
import com.xingej.wechat.enums.ProductStatusEnums;
import com.xingej.wechat.enums.ResultEnum;
import com.xingej.wechat.exception.SellException;
import com.xingej.wechat.repository.ProductInfoRepository;
import com.xingej.wechat.service.ProductService;

/**
 * 
 * @author erjun 2017年12月10日 上午5:46:04
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnums.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXI);
            }
            Integer resultNum = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(resultNum);
            productInfoRepository.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        // 遍历 购物车cartDTOList
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXI);
            }

            Integer num = productInfo.getProductStock() - cartDTO.getProductQuantity();

            // 这里很明显，如果有多线程的话，就会出现 "超卖"现象，也就是说 并发现象
            // 可以使用redis 的锁机制来进行解决
            // 说明，库存不足
            if (num < 0) {
                throw new SellException(ResultEnum.PRODUC_STOCK_ERROR);
            }

            productInfo.setProductStock(num);
            productInfoRepository.save(productInfo);
        }
    }

}
