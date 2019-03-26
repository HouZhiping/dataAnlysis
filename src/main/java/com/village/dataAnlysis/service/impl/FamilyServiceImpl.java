package com.village.dataAnlysis.service.impl;

import com.github.pagehelper.Page;
import com.village.dataAnlysis.domain.entity.FamilyEntity;
import com.village.dataAnlysis.domain.mapper.FamilyMapper;
import com.village.dataAnlysis.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyMapper familyMapper;

    @Override
    public Page<FamilyEntity> findFamilyUnderPage(FamilyEntity familyEntity) {
        return familyMapper.findFamilyUnderPage(familyEntity);
    }

    @Override
    public void addFamily(FamilyEntity familyEntity) throws Exception{
        familyMapper.addFamilyInfo(familyEntity);
    }

    @Override
    public int removeFamily(FamilyEntity familyEntity) throws Exception {
        return familyMapper.delFamily(familyEntity);
    }

    @Override
    public int editFamily(FamilyEntity familyEntity) throws Exception {
        return familyMapper.updateFamilyById(familyEntity);
    }

    @Override
    public Page<FamilyEntity> findFamilyByHuZhuUnderPage(String hu_zhu) {
        return familyMapper.findFamilyByHuZhuUnderPage(hu_zhu);
    }

    @Override
    public int batchDelFamilies(String[] idArr) throws Exception {
        return familyMapper.batchDelFamilies(idArr);
    }


}
