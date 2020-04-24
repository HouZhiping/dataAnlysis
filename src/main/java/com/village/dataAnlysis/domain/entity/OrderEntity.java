package com.village.dataAnlysis.domain.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 'longqiao_info.an_ren_kou_shu_tong_ji_jia_ting_shu_view' is not BASE TABLE
 * </p>
 *
 * @author houzhiping
 * @since 2019-10-25
 */
//@Setter
//@Getter

@Data
@Accessors(chain = true)
@TableName("order_info")
public class OrderEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Integer id;

    /**
     * 订单编码
     */
    private String orderCode;

    /**
     * 订单日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date orderDate;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 客户地址
     */
    private String customerAddr;

    /**
     * 客户电话
     */
    private String customerTel;

    /**
     * 计划预付款
     */
    private BigDecimal planFrontMoney;

    /**
     * 实际预付款
     */
    private BigDecimal realityFrontMoney;

    /**
     * 型号Id
     */
//    private Integer standardsId;

    /**
     * 商品总数
     */
//    private Integer amount;

    /**
     * 单价
     */
//    private BigDecimal unit_price;

    /**
     * 计划发货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") //返回到前台的时间格式
    @DateTimeFormat(pattern ="yyyy-MM-dd")  //接收前台时间的格式
    private Date goodsSendPlanTime;

    /**
     * 实际发货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date goodsSendRealityTime;

    /**
     * 计划收货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date getGoodsPlanTime;

    /**
     * 实际收货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date getGoodsRealityTime;

    /**
     * 计划安装时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date installPlanTime;

    /**
     * 实际安装时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date installRealityTime;

    /**
     * 计划尾款数
     */
    private BigDecimal planEndMoney;

    /**
     * 实际尾款数
     */
    private BigDecimal realityEndMoney;

    /**
     * 安装方式
     */
//    private String machining_type;

    /**
     * 安装地方
     */
//    private String machining_place;

    /**
     * 备注
     */
    private String comment;





}
