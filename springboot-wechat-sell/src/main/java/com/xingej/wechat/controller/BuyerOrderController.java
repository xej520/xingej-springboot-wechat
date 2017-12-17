package com.xingej.wechat.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xingej.wechat.converter.OrderForm2OrderDTOConverter;
import com.xingej.wechat.dto.OrderDTO;
import com.xingej.wechat.enums.ResultEnum;
import com.xingej.wechat.exception.SellException;
import com.xingej.wechat.form.OrderForm;
import com.xingej.wechat.service.OrderService;
import com.xingej.wechat.utils.ResultVOUtil;
import com.xingej.wechat.vo.ResultVO;

/**
 * 
 * @author erjun 2017年12月17日 上午10:47:01
 */
@RestController
@RequestMapping(value = "/buyer/order")
public class BuyerOrderController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderService orderService;

    // @Autowired
    // private BuyerService buyerService;

    // 创建订单
    @PostMapping(value = "/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    // 如果抛异常的话，这里getDefaultMessage 就是
                    // OrderForm 属性上的注解，如"手机号必填"等，就是提示更加明确了
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        // 创建订单
        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    // 订单列表

    // 取消订单

}
