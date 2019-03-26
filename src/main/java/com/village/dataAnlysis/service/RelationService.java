package com.village.dataAnlysis.service;

import com.village.dataAnlysis.domain.entity.RelationEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author houzhiping
 * @since 2019-03-18
 */
public interface RelationService extends IService<RelationEntity> {

    List<RelationEntity> selAllList();

}
