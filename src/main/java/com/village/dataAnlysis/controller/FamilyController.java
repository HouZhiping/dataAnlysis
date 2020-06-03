package com.village.dataAnlysis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.village.dataAnlysis.domain.entity.FamilyEntity;
import com.village.dataAnlysis.domain.entity.PopulationEntity;
import com.village.dataAnlysis.service.FamilyService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/family")
public class FamilyController{

    @Autowired
    private FamilyService familyServiceImpl;

    @RequestMapping("/test")
    public String test(){
        return "hello!";
    }

    /**
     * 分页获取家庭列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("listUnderPage")
//    @RequiresAuthentication
    public PageInfo<FamilyEntity> findFamilyUnderPage(@RequestParam(defaultValue = "1") int pageNo,
                                                      @RequestParam(defaultValue = "10") int pageSize, FamilyEntity familyEntity){
        /*if (!SecurityUtils.getSubject().isAuthenticated()) {
            throw new AuthorizationException("没有权限");
        }*/

        PageHelper.startPage(pageNo,pageSize);
        PageInfo<FamilyEntity> pageInfo = new PageInfo<>(familyServiceImpl.findFamilyUnderPage(familyEntity));

        return pageInfo;
    }

    /**
     *
     * @param pageNo
     * @param pageSize
     * @param hu_zhu
     * @return
     */
    @RequestMapping("findFamilyBuHuZhu")
    public PageInfo<FamilyEntity> findFamilyByHuZhuUnderPage(@RequestParam(defaultValue = "1") int pageNo,
                                                      @RequestParam(defaultValue = "10") int pageSize, String hu_zhu){

        PageHelper.startPage(pageNo,pageSize);
        PageInfo<FamilyEntity> pageInfo = new PageInfo<>(familyServiceImpl.findFamilyByHuZhuUnderPage(hu_zhu));

        return pageInfo;
    }

    /**
     * 增加家庭
     * @param familyEntity
     * @return
     */
    @RequestMapping("addFamily")
    public Map<String,Object> addFamily(FamilyEntity familyEntity){

        Map<String,Object> map = new HashMap<>();
        map.put("status",1);//表示添加成功
        try {
            familyServiceImpl.addFamily(familyEntity);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);//表示添加失败
        }

        return map;
    }

    /**
     * 删除家庭
     * @param familyEntity
     * @return
     */
    @RequestMapping("removeFamily")
    public Map<String,Object> removeFamily(FamilyEntity familyEntity){

        Map<String,Object> map = new HashMap<>();
        map.put("status",1);//表示删除成功
        try {
            familyServiceImpl.removeFamily(familyEntity);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);//表示删除失败
        }

        return map;
    }

    /**
     * 编辑家庭信息
     * @param familyEntity
     * @return
     */
    @RequestMapping("editFamily")
    public Map<String,Object> editFamily(FamilyEntity familyEntity){

        Map<String,Object> map = new HashMap<>();
        map.put("status",1);//表示更新成功
        try {
            familyServiceImpl.editFamily(familyEntity);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);//表示更新失败
        }

        return map;
    }

    /**
     * 批量删除家庭
     * @param ids
     * @return
     */
    @RequestMapping("batchRemoveFamily")
    public Map<String,Object> batchRemoveFamily(String ids){
        Map<String,Object> map = new HashMap<>();
        map.put("status",1);//表示批量删除成功
        if(ids == null){
            map.put("status",0);//表示批量删除失败
            return map;
        }

        String[] idArr = ids.split(",");

        try {
            familyServiceImpl.batchDelFamilies(idArr);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);//表示批量删除失败
        }

        return map;
    }




}
