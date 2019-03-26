package com.village.dataAnlysis.service.impl;

import com.village.dataAnlysis.domain.entity.RelationEntity;
import com.village.dataAnlysis.domain.mapper.RelationMapper;
import com.village.dataAnlysis.service.RelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 'longqiao_info.an_ren_kou_shu_tong_ji_jia_ting_shu_view' is not BASE TABLE 服务实现类
 * </p>
 *
 * @author houzhiping
 * @since 2019-03-18
 */
@Service
public class RelationServiceImpl extends ServiceImpl<RelationMapper, RelationEntity> implements RelationService {

    @Autowired
    private RelationMapper relationMapper;
    @Override
    public List<RelationEntity> selAllList() {
        return relationMapper.selAllList();
    }
}
