package com.xingej.wechat.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xingej.wechat.dto.OrderDTO;

/**
 * 订单服务层
 * 
 * @author erjun 2017年12月16日 上午11:04:05
 */
public interface OrderService {

    /**
     * 创建订单.
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单.
     */
    OrderDTO findOne(String orderId);

    /**
     * 根据openid查询订单列表.
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    Page<OrderDTO> findListAll(Pageable pageable);

    /**
     * 取消订单.
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单.
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单.
     */
    OrderDTO paid(OrderDTO orderDTO);
}