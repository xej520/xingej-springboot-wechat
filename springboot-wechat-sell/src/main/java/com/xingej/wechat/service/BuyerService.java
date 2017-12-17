package com.xingej.wechat.service;

import com.xingej.wechat.dto.OrderDTO;

/**
 * 买家，为了controller的优化
 * 
 * @author erjun 2017年12月17日 下午3:05:21
 */
public interface BuyerService {
    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
