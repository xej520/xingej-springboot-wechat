package com.xingej.wechat.repository;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.xingej.wechat.BaseTest;
import com.xingej.wechat.dataobject.OrderMaster;

public class OrderMasterRepositoryTest extends BaseTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "20171216";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("spark");
        orderMaster.setBuyerPhone("112345678");
        orderMaster.setBuyerAddress("beijing");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);

        System.out.println("---->:\t" + result.toString());

    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request = new PageRequest(1, 3);

        Page<OrderMaster> result = repository.findByBuyerOpenid("002", request);

        System.out.println("---->:\t" + result.getSize());
    }

}
