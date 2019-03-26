package com.village.dataAnlysis.domain.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.village.dataAnlysis.domain.entity.FamilyEntity;
import org.apache.ibatis.annotations.*;

//@Mapper
public interface FamilyMapper extends BaseMapper<FamilyEntity> {

    String insertSql = "INSERT INTO family_info (hu_hao,hu_zhu,`name`,ren_shu,di_zhi,chen_li_shi_jian,zhu_jie,lei_xing,wei_du,jing_du," +
            "chuang_jian_shi_shi,geng_xin_shi_jian) " +
            "VALUE (#{hu_hao},#{hu_zhu},#{name},#{ren_shu},#{di_zhi},#{chen_li_shi_jian},#{zhu_jie},#{lei_xing},#{wei_du},#{jing_du}," +
            "#{chuang_jian_shi_shi},#{geng_xin_shi_jian})";

    String delByIdSql = "DELETE FROM family_info WHERE id = #{id}";

    String batchDelSql = "<script>delete from family_info where id in" +
            "<foreach item='item' index='index' collection='array' open='(' separator=',' close=')'>#{item}</foreach></script>";

    String updateByIdSql = "<script>update family_info set " +
            "<if test='#{hu_hao != null}'>hu_hao=#{hu_hao},</if> " +
            "<if test='#{hu_zhu != null}'>hu_zhu=#{hu_zhu},</if> " +
            "<if test='#{name != null}'>`name`=#{name},</if> " +
            "<if test='#{ren_shu != null}'>ren_shu=#{ren_shu},</if> " +
            "<if test='#{di_zhi != null}'>di_zhi=#{di_zhi},</if> " +
            "<if test='#{chen_li_shi_jian != null}'>chen_li_shi_jian=#{chen_li_shi_jian},</if> " +
            "<if test='#{zhu_jie != null}'>zhu_jie=#{zhu_jie},</if> " +
            "<if test='#{lei_xing != null}'>lei_xing=#{lei_xing},</if> " +
            "<if test='#{wei_du != null}'>wei_du=#{wei_du},</if> " +
            "<if test='#{jing_du != null}'>jing_du=#{jing_du},</if> " +
            "<if test='#{chuang_jian_shi_shi != null}'>chuang_jian_shi_shi=#{chuang_jian_shi_shi},</if> " +
            "<if test='#{geng_xin_shi_jian != null}'>geng_xin_shi_jian=#{geng_xin_shi_jian}</if> " +
            " where id=#{id} " +
            "</script>";

    String selByHu_zhuNameSql = "<script>select * from family_info <if test=\"hu_zhu !=null and hu_zhu != null\">" +
            "where hu_zhu like CONCAT(CONCAT('%',#{hu_zhu}),'%')</if></script>";

    @Insert(insertSql)
    void addFamilyInfo(FamilyEntity familyEntity) throws Exception;

    @Select(selByHu_zhuNameSql)
    Page<FamilyEntity> findFamilyUnderPage(FamilyEntity familyEntity);

    /*@Select(selByHu_zhuNameSql)
    Page<FamilyEntity> findFamilyByHuZhuUnderPage(FamilyEntity familyEntity);*/

    @Select(selByHu_zhuNameSql)
    Page<FamilyEntity> findFamilyByHuZhuUnderPage(@Param("hu_zhu") String hu_zhu);

    @Delete(delByIdSql)
    int delFamily(FamilyEntity familyEntity);

    @Delete(batchDelSql)
    int batchDelFamilies(String[] idArr);

    @Update(updateByIdSql)
    int updateFamilyById(FamilyEntity familyEntity);

}
