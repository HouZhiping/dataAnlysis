package com.village.dataAnlysis.service.impl;

import com.village.dataAnlysis.domain.entity.OrderEntity;
import com.village.dataAnlysis.domain.mapper.OrderMapper;
import com.village.dataAnlysis.domain.mapper.PopulationMapper;
import com.village.dataAnlysis.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 'longqiao_info.an_ren_kou_shu_tong_ji_jia_ting_shu_view' is not BASE TABLE 服务实现类
 * </p>
 *
 * @author houzhiping
 * @since 2019-10-25
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {


    @Autowired
    private OrderMapper orderMapper;










}
