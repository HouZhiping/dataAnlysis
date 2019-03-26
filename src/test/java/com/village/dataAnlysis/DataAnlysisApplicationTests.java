package com.village.dataAnlysis;

import com.village.dataAnlysis.domain.entity.*;
import com.village.dataAnlysis.domain.mapper.*;
import com.village.dataAnlysis.service.PopulationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataAnlysisApplicationTests {

    @Autowired
    private PopulationService populationServiceImpl;
    @Autowired
    private PopulationMapper populationMapper;
    @Autowired
    private FamilyMapper familyMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private RelationCodeMapper relationCodeMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 提取组号信息
     */
    /*@Test
    public void contextLoads() {
        List<GroupEntity> groupEntities = groupMapper.findAllGroup();
        List<PopulationEntity> list = populationMapper.findPopulation();
        for (PopulationEntity populationEntity : list) {
            String addrStr = populationEntity.getZhu_zhi();
            for (GroupEntity groupEntity : groupEntities) {
                String groupName = groupEntity.getName();
                if (addrStr.contains(groupName)) {
                    System.out.println(groupName + ">>>>---" + groupEntity.getId() + "---" + groupEntity.getName());
                    populationEntity.setShe_hao(groupEntity.getId());
                    populationMapper.updatePopulation(populationEntity);
                }

            }
            System.out.println(populationEntity.toString());
        }
    }*/

    /**
     * 计算出生日期
     */
//    @Test
    /*public void dealBirthday() {

        List<PopulationEntity> list = populationMapper.findPopulation();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        for (PopulationEntity populationEntity : list) {
            String sfzh = populationEntity.getSfzh();
            String csrqStr = sfzh.substring(6, 14);//截取出生日期信息
            try {
                populationEntity.setCsrq(sdf.parse(csrqStr));
                System.out.println(sdf.parse(csrqStr));
                populationMapper.updatePopulation(populationEntity);
            } catch (ParseException e) {
                e.printStackTrace();
                continue;
            }

        }
    }*/

    /**
     * 计算年龄
     */
   /* @Test
    public void dealAge(){

        List<PopulationEntity> list = populationMapper.findPopulation();
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        for(PopulationEntity populationEntity : list){

            Date birthDay = populationEntity.getCsrq();
            cal.setTime(birthDay);
            int yearBirth = cal.get(Calendar.YEAR);
            populationEntity.setNian_ling(yearNow - yearBirth);
            populationMapper.updatePopulation(populationEntity);

        }
    }*/

    /*@Test
    public void findOverHuhao(){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT hu_hao FROM population_info WHERE YHZGX = '户主'");
        Map<String,Boolean> huHaoMapByHuZhu = new HashMap<>();
        for(Map<String,Object> map : list){
            huHaoMapByHuZhu.put(map.get("hu_hao")+"",true);
        }

        List<Map<String,Object>> list1 = jdbcTemplate.queryForList("SELECT hu_hao FROM population_info GROUP BY hu_hao");
//        List<String> huHaoList = new ArrayList<>();
        String surplusHuHao = "";
        for(Map<String,Object> map : list1){
            String huHaoStr = map.get("hu_hao")+"";
            if(huHaoMapByHuZhu.get(huHaoStr) == null || !huHaoMapByHuZhu.get(huHaoStr)){
                surplusHuHao += (huHaoStr + ",");
            }
        }
        System.out.println(surplusHuHao);
    }*/

    /*@Test
//    @Transactional
    public void inject2FamilyInfo() throws Exception{
        List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT * FROM `population_info` where YHZGX = '户主'");
        for(Map<String,Object> map : list){
            String huHao = map.get("hu_hao")+"";
            String name = map.get("xing_ming") + "";
            String addr = map.get("zhu_zhi")+"";
            Map<String,Object> map1 = jdbcTemplate.queryForMap("SELECT COUNT(*) AS  ren_shu FROM population_info WHERE hu_hao = " + huHao);
            Integer renShu = Integer.parseInt(map1.get("ren_shu")+"");

            FamilyEntity familyEntity = new FamilyEntity();
            familyEntity.setHu_hao(huHao);//户号
            familyEntity.setHu_zhu(name);//户主名称
            familyEntity.setDi_zhi(addr);//地址
            familyEntity.setRen_shu(renShu);//家庭人数
            familyEntity.setName(name);//家庭名称（一般和户主名称一致）

//            familyMapper.addFamilyInfo(familyEntity);


        }

    }*/

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<RelationCode> userList = relationCodeMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }




     @Test
    public void contextLoads() {





//        List<GroupEntity> groupEntities = groupMapper.findAllGroup();
//        List<PopulationEntity> list = populationMapper.findPopulation();
//        for (PopulationEntity populationEntity : list) {
//            String addrStr = populationEntity.getZhu_zhi();
//            for (GroupEntity groupEntity : groupEntities) {
//                String groupName = groupEntity.getName();
//                if (addrStr.contains(groupName)) {
//                    System.out.println(groupName + ">>>>---" + groupEntity.getId() + "---" + groupEntity.getName());
//                    populationEntity.setShe_hao(groupEntity.getId());
//                    populationMapper.updatePopulation(populationEntity);
//                }
//
//            }
//            System.out.println(populationEntity.toString());
//        }
    }






}

