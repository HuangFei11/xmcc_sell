package com.xmcc.wx_sell.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity//表示当前类为实体类
@DynamicUpdate//设置为ture 表示update对象的时候 生成动态的update语句，如果这个字段的值是null就不会加入到update语句中
@Table(name = "order_detail")//表名
@Builder
public class OrderDetail implements Serializable {
    @Id
    private String detailId;
    private String orderId;     //订单id.
    private String productId;   //商品id.
    private String productName; //商品名称.
    private BigDecimal productPrice;  //商品单价.
    private Integer productQuantity;  //商品数量.
    private String productIcon;       //商品小图.
}
