package com.village.dataAnlysis.domain.mapper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.village.dataAnlysis.domain.entity.PopulationEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@TableName(value="population_info")
public interface PopulationMapper extends BaseMapper<PopulationEntity>{

    String insertSql = "INSERT INTO population_info (hu_hao,YHZGX,xing_ming,SFZH,CSRQ,nian_ling,xing_bei,min_zu,zhu_zhi," +
            "she_hao,dian_hua,xian_ju_zhu_di,fang_wu,bei_zhu,chuangjian_shijian,gengxin_shijian ) VALUES " +
            "(#{hu_hao},#{yhzgx},#{xing_ming},#{sfzh},#{csrq},#{nian_ling}," +
            "#{xing_bei},#{min_zu},#{zhu_zhi},#{she_hao},#{dian_hua},#{xian_ju_zhu_di},#{fang_wu},#{bei_zhu}," +
            "#{chuangjian_shijian},#{gengxin_shijian});";

    String delByIdSql = "delete from population_info where id=#{id}";

    String batchDelSql = "<script>delete from population_info where id in" +
            "<foreach item='item' index='index' collection='array' open='(' separator=',' close=')'>#{item}</foreach></script>";

    String updateSql = "<script>update population_info <set> " +
            "<if test=\"hu_hao != null and hu_hao != ''\">hu_hao=#{hu_hao},</if> " +
            "<if test=\"yhzgx != null  and yhzgx != ''\">yhzgx=#{yhzgx},</if> " +
            "<if test=\"xing_ming != null  and xing_ming != ''\">xing_ming=#{xing_ming},</if> " +
            "<if test=\"sfzh != null and sfzh != ''\">sfzh=#{sfzh},</if> " +
            "<if test=\"csrq != null\">csrq=#{csrq},</if> " +
            "<if test=\"nian_ling != null and nian_ling != ''\">nian_ling=#{nian_ling},</if> " +
            "<if test=\"xing_bei != null and xing_bei != ''\">xing_bei=#{xing_bei},</if> " +
            "<if test=\"min_zu != null and min_zu != ''\">min_zu=#{min_zu},</if> " +
            "<if test=\"zhu_zhi != null and zhu_zhi != ''\">zhu_zhi=#{zhu_zhi},</if> " +
            "<if test=\"dian_hua != null and dian_hua != ''\">dian_hua=#{dian_hua},</if> " +
            "<if test=\"xian_ju_zhu_di != null and xian_ju_zhu_di != ''\">xian_ju_zhu_di=#{xian_ju_zhu_di},</if> " +
            "<if test=\"fang_wu != null and fang_wu != ''\">fang_wu=#{fang_wu},</if> " +
            "<if test=\"bei_zhu != null and bei_zhu != ''\">bei_zhu=#{bei_zhu},</if> " +
            "<if test=\"she_hao != null and she_hao != ''\">she_hao=#{she_hao},</if> " +
            "<if test=\"chuangjian_shijian != null and chuangjian_shijian != ''\">chuangjian_shijian=#{chuangjian_shijian},</if> " +
            "<if test=\"gengxin_shijian != null and gengxin_shijian != ''\">gengxin_shijian=#{gengxin_shijian}</if> " +
            "</set> where id=#{id} " +
            "</script>";

    String selByXing_mingSql = "<script>select * from population_info <if test=\"#{xing_ming}!=null\">" +
            "where xing_ming like CONCAT(CONCAT('%',#{xing_ming}),'%')</if></script>";

    String selNationInfoSql = "SELECT * FROM mz";


    /**
     * 新增人口
     * @param populationEntity
     * @throws Exception
     */
    @Insert(insertSql)
    void addPopulationInfo(PopulationEntity populationEntity) throws Exception;

    /**
     * 通过姓名分页查询人口
     * @param
     * @return
     */
   /* @Select(selByXing_mingSql)
    Page<PopulationEntity> findPopulationByXingMinUnderPage(@Param("xing_ming") String xing_ming);*/

    @Select(selByXing_mingSql)
    Page<PopulationEntity> findPopulationByXingMinUnderPage(PopulationEntity populationEntity);

    /**
     * 通过Id查询人口信息
     * @param populationEntity
     * @return
     */
    @Delete(delByIdSql)
    int delPopulationById(PopulationEntity populationEntity);

    /**
     * 批量删除人口数据
     * @param idArr
     * @return
     */
    @Delete(batchDelSql)
    int batchDelPopulations(String[] idArr);

    /**
     * 通过Id删除人口信息
     * @param populationEntity
     * @return
     */
    @Update(updateSql)
    int updatePopulationById(PopulationEntity populationEntity);

    /**
     * 更新人口信息
     * @param populationEntity
     */
    @Update(updateSql)
    void updatePopulation(PopulationEntity populationEntity);


//    String selByHu_zhuNameSql = "<script>select * from family_info <if test=\"#{hu_zhu}!=null\">" +
//            "where hu_zhu like CONCAT(CONCAT('%',#{hu_zhu}),'%')</if></script>";
    String selPOpulationByXing_ming = "<script>select * from population_info<if test=\"xing_ming !=null and xing_ming != ''\">" +
            "where xing_ming like CONCAT(CONCAT('%',#{xing_ming}),'%')</if></script>";
    @Select(selPOpulationByXing_ming)
    Page<PopulationEntity> findPopulation(PopulationEntity populationEntity);

    @Select(selNationInfoSql)
    List<Map<String, Object>> getNationInfo();

}
