package com.xingej.wechat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/list")
    // 请求的参数比较少，就没有创建 对象，进行表单验证，上面的API参数比较多，因此，创建了针对的
    // 订单的表单验证
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
            @RequestParam(value = "page", defaultValue = "0") Integer page, // 默认是第0页(也就是第一页)，每页显示10条
            @RequestParam(value = "size", defaultValue = "10") Integer size) {

        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = new PageRequest(page, size);

        Page<OrderDTO> orderDTOList = orderService.findList(openid, request);

        // 返回列表
        return ResultVOUtil.success(orderDTOList.getContent());
    }

    // 获取订单详情API
    @GetMapping("detail")
    public ResultVO<OrderDTO> detail(@RequestParam(value = "openid") String openid,
            @RequestParam("orderId") String orderId) {
        // TODO 不安全作为，待改进；由于其他人随便写个openid，就可以查询，不安全
        OrderDTO orderDTO = orderService.findOne(orderId);

        return ResultVOUtil.success(orderDTO);
    }

    // 取消订单

}
