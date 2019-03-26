package com.village.dataAnlysis.CodeGenerator;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.village.dataAnlysis.domain.entity.FamilyEntity;
import com.village.dataAnlysis.domain.entity.PopulationEntity;
import com.village.dataAnlysis.domain.entity.RelationCode;
import com.village.dataAnlysis.domain.entity.RelationEntity;
import com.village.dataAnlysis.domain.mapper.FamilyMapper;
import com.village.dataAnlysis.domain.mapper.PopulationMapper;
import com.village.dataAnlysis.domain.mapper.RelationCodeMapper;
import com.village.dataAnlysis.domain.mapper.RelationMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.relation.Relation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RalationTest {

    @Autowired
    private RelationCodeMapper relationCodeMapper;
    @Autowired
    private RelationMapper relationMapper;
    @Autowired
    private FamilyMapper familyMapper;
    @Autowired
    private PopulationMapper populationMapper;


    /**
     * 程序注入关系，已完成
     */
    @Test
    public void testSelect() {
        /*System.out.println(("----- selectAll method test ------"));
        List<RelationCode> relationCodeList = relationCodeMapper.selectList(null);
        Map<String,Integer> relationCodeMap;
        relationCodeMap = relationCodeList.stream().collect(Collectors.toMap(RelationCode::getRelationName, RelationCode::getId));
        System.out.println(relationCodeMap.toString());

        List<FamilyEntity> familyEntityList = familyMapper.selectList(null);
        familyEntityList.stream().forEach(item ->{
            String huZhuName = item.getHu_zhu();
            QueryWrapper<PopulationEntity> qw = new QueryWrapper<PopulationEntity>();
            qw.eq("hu_hao",item.getHu_hao());
            List<PopulationEntity> populationEntities = populationMapper.selectList(qw);

            RelationEntity relation = new RelationEntity();
            relation.setSource(huZhuName);//源
            populationEntities.forEach(populationEntity -> {
                String yhzgx = populationEntity.getYhzgx();
                if(!"户主".equals(yhzgx)){
                    Integer relationCode = relationCodeMap.get(yhzgx);
                    relation.setRelationCode(relationCode);
                    relation.setTarget(populationEntity.getXing_ming());
                    relation.setNote("程序注入");
                    relationMapper.insert(relation);
                }
            });

            populationEntities.forEach(item1-> System.out.println(item1));
        });*/




//        List<RelationEntity> relationList = relationMapper.selectList(null);
//        relationList.stream().collect(Collectors.toMap(RelationEntity));



    }

}
