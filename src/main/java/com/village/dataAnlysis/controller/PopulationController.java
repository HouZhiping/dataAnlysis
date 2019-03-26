package com.village.dataAnlysis.controller;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.village.dataAnlysis.domain.entity.FamilyEntity;
import com.village.dataAnlysis.domain.entity.PopulationEntity;
import com.village.dataAnlysis.domain.mapper.PopulationMapper;
import com.village.dataAnlysis.service.PopulationService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
//import org.mybatis.logging.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://127.0.0.1:8088", maxAge = 3600)
@RestController
@RequestMapping("/population")
@RequiresAuthentication
public class PopulationController {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PopulationMapper populationMapper;
    @Autowired
    private PopulationService populationServiceImpl;


    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/qureyPopulationByPage")
    public PageInfo<PopulationEntity> qureyPopulationByPage(
            @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize, PopulationEntity populationEntity) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<PopulationEntity> pageInfo = new PageInfo<>(populationServiceImpl.findPopulation(populationEntity));
        return pageInfo;//这个查询会分页
    }

    /**
     * 分页 查询这是测试
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/getNationInfo")
    public List<Map<String, Object>> getNationInfo() {
        return populationServiceImpl.getNationInfo();
    }


    @RequestMapping("/addPopulation")
    public Map<String,Object> addPopulation(PopulationEntity populationEntity){

        Map<String,Object> map = new HashMap<>();
        map.put("status",1);//表示添加成功
        try {
            populationServiceImpl.addPopulation(populationEntity);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);//表示添加失败
        }

        return map;
    }

    @RequestMapping("/removePopulation")
    public Map<String,Object> removePopulation(PopulationEntity populationEntity){

        Map<String,Object> map = new HashMap<>();
        map.put("status",1);//表示添加成功
        try {
            populationServiceImpl.removePopulation(populationEntity);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);//表示添加失败
        }

        return map;
    }


    @RequestMapping("/editPopulation")
    public Map<String,Object> editPopulation(PopulationEntity populationEntity){

        Map<String,Object> map = new HashMap<>();
        map.put("status",1);//表示编辑成功
        try {
            populationServiceImpl.editPopulation(populationEntity);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);//表示编辑失败
        }

        return map;
    }











}
