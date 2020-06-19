package com.village.dataAnlysis.domain.query;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author h
 * @since 2020-06-18
 */
@Data
@TableName("pm_type_info")
@ApiModel("图片分类参数类")
public class PictureTypeQuery  extends Page {

//    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @ApiModelProperty("分类Id")
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
