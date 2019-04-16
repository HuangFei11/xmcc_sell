package com.xmcc.wx_sell.service.impl;

import com.xmcc.wx_sell.common.ResultEnums;
import com.xmcc.wx_sell.common.ResultResponse;
import com.xmcc.wx_sell.dto.ProductCategoryDto;
import com.xmcc.wx_sell.dto.ProductInfoDto;
import com.xmcc.wx_sell.entity.ProductCategory;
import com.xmcc.wx_sell.entity.ProductInfo;
import com.xmcc.wx_sell.repository.ProductCategoryRepository;
import com.xmcc.wx_sell.repository.ProductInfoRepository;
import com.xmcc.wx_sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ResultResponse queryList() {
//        查询所有分类
        List<ProductCategory> all = productCategoryRepository.findAll();
        List<ProductCategoryDto> productCategoryDtoList
                = all.stream().map(productCategory -> ProductCategoryDto.build(productCategory)).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(all)){
            return ResultResponse.fail();
        }
        //获取类目的编号集合
        List<Integer> typeList
                = productCategoryDtoList.stream().map(productCategoryDto -> productCategoryDto.getCategoryType()).collect(Collectors.toList());
        //根据typeList查询商品列表
        List<ProductInfo> productInfoList
                = productInfoRepository.findByProductStatusAndCategoryTypeIn(ResultEnums.PRODUCT_UP.getCode(), typeList);
//        对目标集合productCategoryDtoList进行遍历 取出每个商品的类目编号 设置到对应的目录中
//        将productInfo设置到foods中
//        过滤 ：不同的type进行不同的封装
//        将productInfo转成dto
        List<ProductCategoryDto> productCategoryDtos=productCategoryDtoList.parallelStream().map(productCategoryDto -> {
            productCategoryDto.setProductInfoDtoList(productInfoList.stream()
            .filter(productInfo -> productInfo.getCategoryType() == productCategoryDto.getCategoryType())
            .map(productInfo -> ProductInfoDto.build(productInfo)).collect(Collectors.toList()));
            return productCategoryDto;
        }).collect(Collectors.toList());
        return ResultResponse.success(productCategoryDtos);
    }
}






