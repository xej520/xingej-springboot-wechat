package com.xingej.wechat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xingej.wechat.dataobject.OrderDetail;

/**
 * 订单详情
 * 
 * @author erjun 2017年12月16日 上午10:30:23
 */

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 通过订单id查找订单详情
     * 
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}