package com.village.dataAnlysis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 'longqiao_info.an_ren_kou_shu_tong_ji_jia_ting_shu_view' is not BASE TABLE
 * </p>
 *
 * @author houzhiping
 * @since 2019-03-20
 */
@Data
@Accessors(chain = true)
@TableName("role_info")
public class RoleEntity {

    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private Integer id;
    /**
     * 角色名称
     */
    private String role;

    /**
     * 角色描叙
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;

    private List<Permission> permissions;


}
