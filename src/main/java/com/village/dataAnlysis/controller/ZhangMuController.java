package com.village.dataAnlysis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.village.dataAnlysis.domain.entity.FamilyEntity;
import com.village.dataAnlysis.domain.entity.ZhangMuEntity;
import com.village.dataAnlysis.domain.query.ZhangMuQuery;
import com.village.dataAnlysis.response.BaseResponse;
import com.village.dataAnlysis.service.FamilyService;
import com.village.dataAnlysis.service.ZhangMuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/zhangMu")
public class ZhangMuController {



    @Autowired
    private ZhangMuService zhangMuService;

    @RequestMapping("/pageList")
    public BaseResponse pageList(ZhangMuQuery zhangMuQuery){

        BaseResponse response = new BaseResponse();

        IPage page = zhangMuService.page(zhangMuQuery, new QueryWrapper<ZhangMuEntity>());

        response.setData(page);

        return response;

    }




}
