package com.xmcc.wx_sell.service;

import com.xmcc.wx_sell.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    void batchInsert(List<OrderDetail> list);
}
