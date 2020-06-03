package com.village.dataAnlysis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.village.dataAnlysis.domain.entity.ZhangMuEntity;
import com.village.dataAnlysis.domain.entity.order.ComponentEntity;
import com.village.dataAnlysis.domain.mapper.ZhangMuMapper;
import com.village.dataAnlysis.domain.mapper.order.ComponentMapper;
import com.village.dataAnlysis.service.ZhangMuService;
import com.village.dataAnlysis.service.order.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单物料的service
 */
@Service
public class ZhangMuServiceImpl extends ServiceImpl<ZhangMuMapper, ZhangMuEntity> implements ZhangMuService {

    @Autowired
    private ZhangMuMapper zhangMuMapper;

}
