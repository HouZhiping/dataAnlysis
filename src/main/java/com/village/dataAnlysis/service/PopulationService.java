package com.village.dataAnlysis.service;

import com.github.pagehelper.Page;
import com.village.dataAnlysis.domain.entity.FamilyEntity;
import com.village.dataAnlysis.domain.entity.PopulationEntity;

import java.util.List;
import java.util.Map;

public interface PopulationService {

    List<PopulationEntity> dealData1(PopulationEntity populationEntity);
    Page<PopulationEntity> findPopulation( PopulationEntity populationEntity);


    Page<PopulationEntity> findPopulationUnderPage(PopulationEntity populationEntity);

    void addPopulation(PopulationEntity populationEntity) throws Exception;

    int removePopulation(PopulationEntity populationEntity) throws  Exception;

    void editPopulation(PopulationEntity populationEntity) throws Exception;

    Page<PopulationEntity> findPopulationByNameUnderPage(PopulationEntity populationEntity);

    int batchDelPopulation(String[] idArr) throws Exception;

    List<Map<String, Object>> getNationInfo();


}
