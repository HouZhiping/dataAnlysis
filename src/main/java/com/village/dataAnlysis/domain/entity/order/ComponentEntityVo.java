package com.village.dataAnlysis.domain.entity.order;


import lombok.Data;

@Data
public class ComponentEntityVo extends ComponentEntity {

    //分页，当前是第几页
    private Integer current = 1;

    //分页，当前页有几条数据
    private Integer size=10;

    //模糊查询前台传过来的值
    private String vagueCode;


}
