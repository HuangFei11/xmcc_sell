package com.xmcc.wx_sell.dao;

import java.util.List;

public interface BatchDao<T> {
    void batchInsert(List<T> list);
}
