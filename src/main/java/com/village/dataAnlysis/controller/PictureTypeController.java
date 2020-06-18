package com.village.dataAnlysis.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.village.dataAnlysis.domain.entity.PictureTypeEntity;
import com.village.dataAnlysis.domain.query.PictureTypeQuery;
import com.village.dataAnlysis.response.BaseResponse;
import com.village.dataAnlysis.service.IPictureTypeService;
import com.village.dataAnlysis.service.impl.PictureTypeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author h
 * @since 2020-06-18
 */
@Api(tags = "图片分类接口", description = "这是图片分类相关接口")
@RestController
@RequestMapping("/pictureType")
public class PictureTypeController {

    @Autowired
    private IPictureTypeService pictureTypeService;

    /**
     * 获取图片
     * @param pictureTypeQuery
     * @return
     */
    @RequestMapping("/listPictureTypes")
    @ApiOperation("图片分类全列表")
    public BaseResponse<List<PictureTypeEntity>> listPictureTypes(PictureTypeQuery pictureTypeQuery){
        return new BaseResponse<>(pictureTypeService.listPictureTypes(pictureTypeQuery));
    }





}
