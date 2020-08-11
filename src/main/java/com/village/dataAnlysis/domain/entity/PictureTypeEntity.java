package com.village.dataAnlysis.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author h
 * @since 2020-06-18
 */
@Data
@ApiModel("图片分类实体")
@TableName("pm_type_info")
public class PictureTypeEntity implements Serializable {

//    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @ApiModelProperty("主键Id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名称
     */
    @ApiModelProperty("图片分类名称")
    private String typeName;

    /**
     * 父Id
     */
    @ApiModelProperty("图片分类父Id")
    private Integer parentId;

    /**
     * 备注
     */
    @ApiModelProperty("图片分类备注")
    private String comment;


}
