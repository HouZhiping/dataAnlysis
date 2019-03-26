package com.village.dataAnlysis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

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
@TableName("user_info")
public class UserEntity {

    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 备注
     */
    private String comment;

    /**
     * 一个管理员具有多个角色
     */
    private List<RoleEntity> roles;


}
