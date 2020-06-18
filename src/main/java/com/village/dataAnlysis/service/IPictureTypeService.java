package com.village.dataAnlysis.service;

import com.village.dataAnlysis.domain.entity.PictureTypeEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.village.dataAnlysis.domain.query.PictureTypeQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author h
 * @since 2020-06-18
 */
public interface IPictureTypeService extends IService<PictureTypeEntity> {


    List<PictureTypeEntity> listPictureTypes(PictureTypeQuery pictureTypeQuery);

}
