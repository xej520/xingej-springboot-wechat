package com.xingej.wechat.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.xingej.wechat.converter.OrderMaster2OrderDTOConverter;
import com.xingej.wechat.dataobject.OrderDetail;
import com.xingej.wechat.dataobject.OrderMaster;
import com.xingej.wechat.dataobject.ProductInfo;
import com.xingej.wechat.dto.CartDTO;
import com.xingej.wechat.dto.OrderDTO;
import com.xingej.wechat.enums.OrderStatusEnum;
import com.xingej.wechat.enums.PayStatusEnum;
import com.xingej.wechat.enums.ResultEnum;
import com.xingej.wechat.exception.SellException;
import com.xingej.wechat.repository.OrderDetailRepository;
import com.xingej.wechat.repository.OrderMasterRepository;
import com.xingej.wechat.service.OrderService;
import com.xingej.wechat.service.ProductService;
import com.xingej.wechat.utils.KeyUtil;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        // 产生随机的订单ID
        String orderId = KeyUtil.genUniqueKey();

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        // 1、查询商品(数量，价格)
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());

            if (productInfo == null) {
                // 查询为空的话，就抛异常
                throw new SellException(ResultEnum.PRODUCT_NOT_EXI);
                // throw new ResponseBankException();
            }

            // 2. 计算订单总价
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            // 订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);

            orderDetailRepository.save(orderDetail);
        }

        // 3、写入订单数据库(orderMaster 和 orderDetail)
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(orderAmount);
        orderMasterRepository.save(orderMaster);

        // 4、扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());

        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    // 查询单个订单
    @Override
    public OrderDTO findOne(String orderId) {

        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        if (orderMaster == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EX);
        }

        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

    // 查询订单的列表
    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderDTOPage = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);

        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderDTOPage.getContent());
        Page<OrderDTO> dtoPage = new PageImpl<OrderDTO>(orderDTOList, pageable, orderDTOPage.getTotalElements());

        return dtoPage;
    }

    @Override
    public Page<OrderDTO> findListAll(Pageable pageable) {
        return null;
    }

    // 去掉订单
    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    // 完成订单
    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    // 支付订单
    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }

}
