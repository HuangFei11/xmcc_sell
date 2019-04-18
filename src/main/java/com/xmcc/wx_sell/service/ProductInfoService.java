package com.xmcc.wx_sell.service;

import com.xmcc.wx_sell.common.ResultResponse;
import com.xmcc.wx_sell.entity.ProductInfo;


public interface ProductInfoService {

    ResultResponse queryList();
//    根据id查询商品
    ResultResponse<ProductInfo> queryById(String productId);
//修改商品库存的方法
    void updateProduct(ProductInfo productInfo);
}
