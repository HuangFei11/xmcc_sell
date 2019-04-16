package com.xmcc.wx_sell.repository;

import com.xmcc.wx_sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{
//    根据类目的状态和编号查询商品
        List<ProductInfo> findByProductStatusAndCategoryTypeIn(Integer status,List<Integer> typeList);
}
