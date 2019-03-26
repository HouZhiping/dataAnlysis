package com.village.dataAnlysis.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;

@Data
@TableName("relation_code_info")
public class RelationCode {

    private Integer id;
    private String relationName;
    private String note;

}
