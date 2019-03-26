package com.village.dataAnlysis.service;

import com.github.pagehelper.Page;
import com.village.dataAnlysis.domain.entity.FamilyEntity;
import org.springframework.stereotype.Service;

public interface FamilyService {
    Page<FamilyEntity> findFamilyUnderPage(FamilyEntity familyEntity);

    void addFamily(FamilyEntity familyEntity) throws Exception;

    int removeFamily(FamilyEntity familyEntity) throws  Exception;

    int editFamily(FamilyEntity familyEntity) throws Exception;

    Page<FamilyEntity> findFamilyByHuZhuUnderPage(String hu_zhu);

    int batchDelFamilies(String[] idArr) throws Exception;
}
