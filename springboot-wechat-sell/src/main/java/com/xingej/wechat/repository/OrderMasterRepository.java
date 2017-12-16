package com.xingej.wechat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xingej.wechat.dataobject.OrderMaster;

/**
 * 
 * <OrderMaster, String> value：主键是String类型
 * 
 * @author erjun 2017年12月16日 上午10:27:19
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 通过买家的openID来查询
     * 
     * 支持分页查询
     * 
     * @param buyerOpenId
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);
}
