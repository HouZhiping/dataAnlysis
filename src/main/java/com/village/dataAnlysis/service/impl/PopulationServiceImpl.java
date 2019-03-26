package com.village.dataAnlysis.service.impl;

import com.github.pagehelper.Page;
import com.village.dataAnlysis.domain.entity.PopulationEntity;
import com.village.dataAnlysis.domain.mapper.PopulationMapper;
import com.village.dataAnlysis.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PopulationServiceImpl implements PopulationService {

    @Autowired
    private PopulationMapper populationMapper;


    public List<PopulationEntity> dealData1(PopulationEntity populationEntity) {
        List<PopulationEntity> list = populationMapper.findPopulation(populationEntity);
        for(PopulationEntity populationEntity1 : list){
            String addrStr = populationEntity1.getZhu_zhi();
        }
        return list;
    }

    public Page<PopulationEntity> findPopulation( PopulationEntity populationEntity) {
        return populationMapper.findPopulation(populationEntity);
    }

    @Override
    public Page<PopulationEntity> findPopulationUnderPage(PopulationEntity populationEntity) {

        return populationMapper.findPopulationByXingMinUnderPage(populationEntity);

    }

    @Override
    public void addPopulation(PopulationEntity populationEntity) throws Exception {
        populationMapper.addPopulationInfo(populationEntity);
    }

    @Override
    public int removePopulation(PopulationEntity populationEntity) throws Exception {
        return populationMapper.delPopulationById(populationEntity);
    }

    @Override
    public void editPopulation(PopulationEntity populationEntity) throws Exception {
        populationMapper.updatePopulation(populationEntity);
    }

    @Override
    public Page<PopulationEntity> findPopulationByNameUnderPage(PopulationEntity populationEntity) {
        return populationMapper.findPopulationByXingMinUnderPage(populationEntity);
    }

    @Override
    public int batchDelPopulation(String[] idArr) throws Exception {
        return populationMapper.batchDelPopulations(idArr);
    }

    @Override
    public List<Map<String, Object>> getNationInfo() {
        return populationMapper.getNationInfo();
    }


}
