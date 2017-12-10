package com.xingej.wechat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xingej.wechat.dataobject.ProductCategory;
import com.xingej.wechat.dataobject.ProductInfo;
import com.xingej.wechat.service.CategoryService;
import com.xingej.wechat.service.ProductService;
import com.xingej.wechat.utils.ResultVOUtil;
import com.xingej.wechat.vo.ProductInfoVO;
import com.xingej.wechat.vo.ProductVO;
import com.xingej.wechat.vo.ResultVO;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        // 1:查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2：查询类目(一次性查询)
        List<Integer> categoryTypeList = new ArrayList<>();
        // 如果初始化categoryTypeList？ 有两种方法
        boolean flag = false;// 我这里，默认使用了方式二

        if (flag) {
            // 方式一：传统方法，使用for循环
            for (ProductInfo productInfo : productInfoList) {
                categoryTypeList.add(productInfo.getCategoryType());
            }
        } else {
            // 方式二：精简方法(java8特性，lamba)

            categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        }

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();

                    // 属性拷贝，将productInfo对象里的属性，拷贝到productInfoVO里面
                    BeanUtils.copyProperties(productInfo, productInfoVO);

                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
