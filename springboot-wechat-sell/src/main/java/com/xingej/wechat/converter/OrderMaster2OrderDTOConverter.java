package com.xingej.wechat.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.xingej.wechat.dataobject.OrderMaster;
import com.xingej.wechat.dto.OrderDTO;

/**
 * 转换器
 * 
 * @author erjun 2017年12月17日 上午9:50:21
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);

        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());

    }
}