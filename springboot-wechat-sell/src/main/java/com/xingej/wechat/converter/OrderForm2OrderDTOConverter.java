package com.xingej.wechat.converter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xingej.wechat.dataobject.OrderDetail;
import com.xingej.wechat.dto.OrderDTO;
import com.xingej.wechat.enums.ResultEnum;
import com.xingej.wechat.exception.SellException;
import com.xingej.wechat.form.OrderForm;

public class OrderForm2OrderDTOConverter {
    private static Logger log = LoggerFactory.getLogger(OrderForm2OrderDTOConverter.class);

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();

        try {
            // 将json转换成list
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception ex) {
            // 有可能orderForm.getItems() 的内容，并不是json格式
            // 因此，需要进行try catch处理
            log.error("【格式转换错误】restl={}", orderForm.getItems());
            log.error(ex.getMessage());
            throw new SellException(ResultEnum.PARAM_ERROR);

        }

        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
