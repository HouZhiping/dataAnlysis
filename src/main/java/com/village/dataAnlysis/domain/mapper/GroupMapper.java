package com.village.dataAnlysis.domain.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.village.dataAnlysis.domain.entity.GroupEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@TableName("group_info")
public interface GroupMapper {

    @Select("SELECT * FROM `group_info`")
    List<GroupEntity>  findAllGroup();

}
