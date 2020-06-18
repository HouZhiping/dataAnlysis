package com.village.dataAnlysis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.village.dataAnlysis.domain.entity.PictureTypeEntity;
import com.village.dataAnlysis.domain.mapper.PictureTypeMapper;
import com.village.dataAnlysis.domain.query.PictureTypeQuery;
import com.village.dataAnlysis.service.IPictureTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author h
 * @since 2020-06-18
 */
@Service
public class PictureTypeServiceImpl extends ServiceImpl<PictureTypeMapper, PictureTypeEntity> implements IPictureTypeService {

    /**
     *  查询
     * @param pictureTypeQuery
     * @return
     */
    @Override
    public List<PictureTypeEntity> listPictureTypes(PictureTypeQuery pictureTypeQuery){

        QueryWrapper<PictureTypeEntity> queryWrapper = new QueryWrapper();

        if(StringUtils.isNotEmpty(pictureTypeQuery.getTypeName())){
            queryWrapper.like("typeName",pictureTypeQuery.getTypeName());
        }

        List<PictureTypeEntity> pictureTypeEntities = this.list(queryWrapper);

        return pictureTypeEntities;
    }



}
