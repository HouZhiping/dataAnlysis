package com.village.dataAnlysis.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Permission {


    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 权限名称
     */
    private String permission;
    /**
     * 权限说明
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;
}
