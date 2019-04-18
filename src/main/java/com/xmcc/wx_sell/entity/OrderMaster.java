package com.xmcc.wx_sell.entity;

import com.xmcc.wx_sell.common.OrderEnums;
import com.xmcc.wx_sell.common.PayEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@Data
@Entity//表示当前类为实体类
@DynamicUpdate//设置为ture 表示update对象的时候 生成动态的update语句，如果这个字段的值是null就不会加入到update语句中
@Table(name = "order_master")//表名
@Builder
public class OrderMaster implements Serializable {
    @Id
    private String orderId;     //订单id.
    private String buyerName;    //买家名字.
    private String buyerPhone;   //买家手机号.
    private String buyerAddress; //买家地址.
    private String buyerOpenid;  //买家微信Openid.
    private BigDecimal orderAmount;//订单总金额.
    private Integer orderStatus = OrderEnums.NEW.getCode();// 订单状态, 默认为0新下单.
    private Integer payStatus = PayEnums.WAIT.getCode();   // 支付状态, 默认为0未支付.
    private Date createTime; //创建时间.
    private Date updateTime; //更新时间.
    public OrderMaster() {
    }
}
