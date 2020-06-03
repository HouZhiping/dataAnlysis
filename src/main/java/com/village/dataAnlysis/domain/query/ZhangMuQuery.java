package com.village.dataAnlysis.domain.query;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.Date;

@Data
@TableName("hm_zhangmu_info")
public class ZhangMuQuery extends Page {

    @TableId(type= IdType.AUTO)
    private Integer id;

    //账目名称
    private String accountName;

    //账目类型 0：出账；1：进账
    private Integer accountType;

    //账目发生时间
    private Date accountTime;

    //账目创建时间
    private Date createTime;

    //账目更新时间
    private Date updateTime;

    //账目金额
    private Float amountMoney;

}
