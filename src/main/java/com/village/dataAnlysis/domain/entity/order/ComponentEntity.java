package com.village.dataAnlysis.domain.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("component_info")
public class ComponentEntity {

    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Integer id;

    private Integer orderId;

    /**
     *
     */
    private String type;

    private Integer amount;

    private Float unitPrice;

    private String comment;

    private String machiningPlace;

    private String machiningType;

    private Integer standardsId;




}
