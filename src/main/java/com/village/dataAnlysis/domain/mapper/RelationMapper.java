package com.village.dataAnlysis.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.village.dataAnlysis.domain.entity.RelationEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RelationMapper extends BaseMapper<RelationEntity> {

    String selAllListSql = "SELECT * FROM `relation_info` ri LEFT JOIN relation_code_info rci ON ri.relationCode = rci.id " +
            "where ri.source like '%涂%' or ri.target like '%涂%'";

    @Select(selAllListSql)
    List<RelationEntity> selAllList();



}
