package com.xingej.wechat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xingej.wechat.BaseTest;
import com.xingej.wechat.dataobject.OrderDetail;
import com.xingej.wechat.dto.OrderDTO;

public class OrderServiceImplTest extends BaseTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "1101110";

    private final String ORDERID = "1500790335414783795";

    @Test
    public void create() throws Exception {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("spark");
        orderDTO.setBuyerAddress("beijing");
        orderDTO.setBuyerPhone("1239876");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        // 购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        // 查看ProductInfo表，看看有没有记录，有的话，把主键ID，写到下面里
        o1.setProductId("402881e5603f614001603f6150370000");
        o1.setProductQuantity(1);// 买了一件

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("402881e5603aeb5b01603aeb64930000");
        o2.setProductQuantity(2);// 买了2件

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);
    }

}
