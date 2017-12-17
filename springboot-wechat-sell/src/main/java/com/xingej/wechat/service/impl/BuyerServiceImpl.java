package com.xingej.wechat.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xingej.wechat.dto.OrderDTO;
import com.xingej.wechat.enums.ResultEnum;
import com.xingej.wechat.exception.SellException;
import com.xingej.wechat.service.BuyerService;
import com.xingej.wechat.service.OrderService;

/**
 * 主要是将BuyerOrderController里的detail API，cancel API 里的
 * 
 * 校验逻辑，集中到这里
 * 
 * @author erjun 2017年12月17日 下午3:08:44
 */
@Service
public class BuyerServiceImpl implements BuyerService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查不到改订单, orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EX);
        }

        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        // 判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致. openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
