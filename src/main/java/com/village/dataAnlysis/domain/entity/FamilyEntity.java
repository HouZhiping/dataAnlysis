package com.village.dataAnlysis.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("family_info")
public class FamilyEntity {

    private Integer id;
    private String hu_hao;
    private String hu_zhu;
    private String di_zhi;
    private String name;
    private Integer ren_shu;
    private String zhu_jie;
    private Integer lei_xing;
    private String wei_du;
    private String jing_du;
    private Date chen_li_shi_jian;
    private Date chuang_jian_shi_shi;//数据创建时间
    private Date geng_xin_shi_jian;//数据更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHu_hao() {
        return hu_hao;
    }

    public void setHu_hao(String hu_hao) {
        this.hu_hao = hu_hao;
    }

    public String getHu_zhu() {
        return hu_zhu;
    }

    public void setHu_zhu(String hu_zhu) {
        this.hu_zhu = hu_zhu;
    }

    public String getDi_zhi() {
        return di_zhi;
    }

    public void setDi_zhi(String di_zhi) {
        this.di_zhi = di_zhi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRen_shu() {
        return ren_shu;
    }

    public void setRen_shu(Integer ren_shu) {
        this.ren_shu = ren_shu;
    }

    public String getZhu_jie() {
        return zhu_jie;
    }

    public void setZhu_jie(String zhu_jie) {
        this.zhu_jie = zhu_jie;
    }

    public Integer getLei_xing() {
        return lei_xing;
    }

    public void setLei_xing(Integer lei_xing) {
        this.lei_xing = lei_xing;
    }

    public String getWei_du() {
        return wei_du;
    }

    public void setWei_du(String wei_du) {
        this.wei_du = wei_du;
    }

    public String getJing_du() {
        return jing_du;
    }

    public void setJing_du(String jing_du) {
        this.jing_du = jing_du;
    }

    public Date getChen_li_shi_jian() {
        return chen_li_shi_jian;
    }

    public void setChen_li_shi_jian(Date chen_li_shi_jian) {
        this.chen_li_shi_jian = chen_li_shi_jian;
    }

    public Date getChuang_jian_shi_shi() {
        return chuang_jian_shi_shi;
    }

    public void setChuang_jian_shi_shi(Date chuang_jian_shi_shi) {
        this.chuang_jian_shi_shi = chuang_jian_shi_shi;
    }

    public Date getGeng_xin_shi_jian() {
        return geng_xin_shi_jian;
    }

    public void setGeng_xin_shi_jian(Date geng_xin_shi_jian) {
        this.geng_xin_shi_jian = geng_xin_shi_jian;
    }
}
