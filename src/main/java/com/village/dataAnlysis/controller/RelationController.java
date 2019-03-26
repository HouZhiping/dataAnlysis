package com.village.dataAnlysis.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.village.dataAnlysis.domain.entity.FamilyEntity;
import com.village.dataAnlysis.domain.entity.RelationEntity;
import com.village.dataAnlysis.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 'longqiao_info.an_ren_kou_shu_tong_ji_jia_ting_shu_view' is not BASE TABLE 前端控制器
 * </p>
 *
 * @author houzhiping
 * @since 2019-03-18
 */
@RestController
@RequestMapping("/relation")
public class RelationController {

    @Autowired
    private RelationService relationServiceImpl;

    @RequestMapping("list")
    public List<RelationEntity> findFamilyUnderPage(@RequestParam(defaultValue = "1") int pageNo,
                                                      @RequestParam(defaultValue = "10") int pageSize, FamilyEntity familyEntity){

        List<RelationEntity> list = relationServiceImpl.selAllList();


        return list;
    }



}
