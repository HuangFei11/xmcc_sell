package com.xmcc.wx_sell.service.impl;

import com.xmcc.wx_sell.dao.impl.BatchDaoImpl;
import com.xmcc.wx_sell.entity.OrderDetail;
import com.xmcc.wx_sell.service.OrderDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class OrderDetailServiceImpl extends BatchDaoImpl<OrderDetail> implements OrderDetailService {
    @Override
    @Transactional//加入事务管理  增删改
    public void batchInsert(List<OrderDetail> list) {
            super.batchInsert(list);
    }
}
