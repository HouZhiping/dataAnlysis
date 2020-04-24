package com.village.dataAnlysis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/echart")
public class EchartController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
//    @Autowired
//    private PopulationMapper populationMapper;
//    @Autowired
//    private PopulationService populationServiceImpl;


    /**
     * 性别占比信息
     * @return
     */
    @RequestMapping("/get_xingbei_info")
    public List<Map<String,Object>> getXingbeiInfo() {
        List<Map<String,Object>> list = jdbcTemplate.queryForList(
                "SELECT count(*) AS `sum`,xing_bei FROM population_info GROUP BY xing_bei");
        System.out.println(6);
        return list;
    }

    @RequestMapping("/get_xingbei_info1")
    public List<Map<String,Object>> getXingbeiInfo1() {
        List<Map<String,Object>> list = jdbcTemplate.queryForList(
                "SELECT count(*) AS `sum`,xing_bei FROM population_info GROUP BY xing_bei");
        System.out.println(888);


        return list;
    }

    /**
     * 年龄分布信息
     * @return
     */
    @RequestMapping("/get_nianling_fenbu")
    public Map<String,List<Map<String,Object>>> getNianLingFenBu() {

        List<Map<String,Object>> list = jdbcTemplate.queryForList(
                "SELECT count(*) AS `sum`, '5岁及以下' AS sign FROM population_info WHERE nian_ling <6 UNION\n" +
                        "SELECT count(*) AS `sum`,'6~10岁' FROM population_info WHERE nian_ling <11 AND nian_ling >5 UNION \n" +
                        "SELECT count(*) AS `sum`,'11~18岁' FROM population_info WHERE nian_ling <19 AND nian_ling >10 UNION \n" +
                        "SELECT count(*) AS `sum`,'19~35岁' FROM population_info WHERE nian_ling <36 AND nian_ling >18 UNION \n" +
                        "SELECT count(*) AS `sum`,'36~60岁' FROM population_info WHERE nian_ling <61 AND nian_ling >35 UNION \n" +
                        "SELECT count(*) AS `sum`,'60~75岁' FROM population_info WHERE nian_ling <76 AND nian_ling >59 UNION \n" +
                        "SELECT count(*) AS `sum`,'76~89岁' FROM population_info WHERE nian_ling <90 AND nian_ling >75 UNION \n" +
                        "SELECT count(*) AS `sum`,'90岁及以上' FROM population_info WHERE nian_ling >89");

        List<Map<String,Object>> listMan = jdbcTemplate.queryForList(
                "SELECT count(*) AS `sum`, '5岁及以下' AS sign FROM population_info WHERE nian_ling <6 AND xing_bei = '女' UNION\n" +
                        "SELECT count(*) AS `sum`,'6~10岁' FROM population_info WHERE nian_ling <11 AND nian_ling >5 AND xing_bei = '男' UNION \n" +
                        "SELECT count(*) AS `sum`,'11~18岁' FROM population_info WHERE nian_ling <19 AND nian_ling >10 AND xing_bei = '男'   UNION \n" +
                        "SELECT count(*) AS `sum`,'19~35岁' FROM population_info WHERE nian_ling <36 AND nian_ling >18 AND xing_bei = '男'   UNION \n" +
                        "SELECT count(*) AS `sum`,'36~60岁' FROM population_info WHERE nian_ling <61 AND nian_ling >35 AND xing_bei = '男'   UNION \n" +
                        "SELECT count(*) AS `sum`,'60~75岁' FROM population_info WHERE nian_ling <76 AND nian_ling >59 AND xing_bei = '男'   UNION \n" +
                        "SELECT count(*) AS `sum`,'76~89岁' FROM population_info WHERE nian_ling <90 AND nian_ling >75 AND xing_bei = '男'   UNION \n" +
                        "SELECT count(*) AS `sum`,'90岁及以上' FROM population_info WHERE nian_ling >89  AND xing_bei = '男'  ");

        List<Map<String,Object>> listWomen = jdbcTemplate.queryForList(
                "SELECT count(*) AS `sum`, '5岁及以下' AS sign FROM population_info WHERE nian_ling <6 AND xing_bei = '女' UNION\n" +
                        "SELECT count(*) AS `sum`,'6~10岁' FROM population_info WHERE nian_ling <11 AND nian_ling >5 AND xing_bei = '女' UNION \n" +
                        "SELECT count(*) AS `sum`,'11~18岁' FROM population_info WHERE nian_ling <19 AND nian_ling >10 AND xing_bei = '女'   UNION \n" +
                        "SELECT count(*) AS `sum`,'19~35岁' FROM population_info WHERE nian_ling <36 AND nian_ling >18 AND xing_bei = '女'   UNION \n" +
                        "SELECT count(*) AS `sum`,'36~60岁' FROM population_info WHERE nian_ling <61 AND nian_ling >35 AND xing_bei = '女'   UNION \n" +
                        "SELECT count(*) AS `sum`,'60~75岁' FROM population_info WHERE nian_ling <76 AND nian_ling >59 AND xing_bei = '女'   UNION \n" +
                        "SELECT count(*) AS `sum`,'76~89岁' FROM population_info WHERE nian_ling <90 AND nian_ling >75 AND xing_bei = '女'   UNION \n" +
                        "SELECT count(*) AS `sum`,'90岁及以上' FROM population_info WHERE nian_ling >89  AND xing_bei = '女'  ");

        Map<String,List<Map<String,Object>>> map = new HashMap<>();
        map.put("总",list);
        map.put("男",listMan);
        map.put("女",listWomen);

        return map;
    }


    /**
     * 获取家庭数
     * @return
     */
    @RequestMapping("/get_jia_ting_shu")
    public List<Map<String,Object>> getJiaTingShu() {

        List<Map<String,Object>> list = jdbcTemplate.queryForList(
                "SELECT '总户数' AS 'ren_kou_shu', count(*) AS 'jia_ting_shu' FROM \n" +
                        "(SELECT  DISTINCT(hu_hao) AS hu_hao FROM population_info) AS newTable UNION \n" +
                        "SELECT CONCAT(`sum`,'人户') AS 'ren_kou_shu',count(*) AS 'jia_ting_shu' FROM \n" +
                        "(SELECT count(*) AS 'sum',hu_hao FROM population_info GROUP BY hu_hao ORDER BY `sum`) AS newTable2 GROUP BY `sum`");

        return list;
    }

    /**
     * 获取每个队的人口数
     * @return
     */
    @RequestMapping("/get_ren_kou_shu_an_dui")
    public List<List<Map<String,Object>>> getRenKouShuAnDui() {

        List<Map<String,Object>> listZong = jdbcTemplate.queryForList(
                "SELECT count(*) AS `sum`,she_hao,`name` FROM `population_info` p " +
                        "LEFT JOIN group_info g ON p.she_hao = g.id GROUP BY p.she_hao ORDER BY p.she_hao;");

        List<Map<String,Object>> listNan = jdbcTemplate.queryForList(
                "SELECT count(*) AS `sum`,she_hao,`name` FROM `population_info` p " +
                        "LEFT JOIN group_info g ON p.she_hao = g.id WHERE xing_bei = '男'  GROUP BY p.she_hao ORDER BY p.she_hao;");

        List<Map<String,Object>> listNv = jdbcTemplate.queryForList(
                "SELECT count(*) AS `sum`,she_hao,`name` FROM `population_info` p " +
                        "LEFT JOIN group_info g ON p.she_hao = g.id WHERE xing_bei = '女'  GROUP BY p.she_hao ORDER BY p.she_hao;");

        List<List<Map<String,Object>>> resultList = new ArrayList<>();
        resultList.add(listZong);
        resultList.add(listNan);
        resultList.add(listNv);

        return resultList;
    }


    /*@RequestMapping("/hello")
    public List<Map<String,Object>> index() {
        List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT * FROM `population_info`");
        return list;
    }*/

    /*@RequestMapping("/dealData")
    public List<Map<String,Object>> dealData() {

        List<Map<String,Object>> populationList = jdbcTemplate.queryForList("SELECT * FROM `population_info`");
        List<Map<String,Object>> sheList = jdbcTemplate.queryForList("SELECT * FROM `she_info`");

        Map<String,Integer> sheMap = new HashMap<>();
        for(Map<String,Object> map : sheList){
            String sheName = map.get("name")+"";
            Integer sheId = Integer.parseInt(map.get("id")+"");
            sheMap.put(sheName,sheId);
        }


        return populationList;
    }*/

    /**
     *
     * @return
     */
    /*@RequestMapping("/dealData1")
    public List<PopulationEntity> dealData1() {
        return populationServiceImpl.dealData1();
    }*/

    //SELECT count(*) AS `sum`,xing_bei FROM population_info GROUP BY xing_bei;








}
