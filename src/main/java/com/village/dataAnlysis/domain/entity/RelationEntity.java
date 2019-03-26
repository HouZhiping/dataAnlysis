package com.village.dataAnlysis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("relation_info")
public class RelationEntity {

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
    private String source;
    private String target;
    private Integer relationCode;
    private String note;
    private String relationName;

}
