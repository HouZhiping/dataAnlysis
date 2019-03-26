package com.village.dataAnlysis.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@TableName("population_info")
public class PopulationEntity {

    private Integer id;
    private String hu_hao;
    private String yhzgx;
    private String xing_ming;
    private String sfzh;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date csrq;
    private Integer nian_ling;
    private String xing_bei;
    private String min_zu;
    private String zhu_zhi;
    private String dian_hua;
    private String xian_ju_zhu_di;
    private String fang_wu;
    private String bei_zhu;
    private Integer she_hao;
    private Date chuangjian_shijian;
    private Date gengxin_shijian;

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

    public String getYhzgx() {
        return yhzgx;
    }

    public void setYhzgx(String yhzgx) {
        this.yhzgx = yhzgx;
    }

    public String getXing_ming() {
        return xing_ming;
    }

    public void setXing_ming(String xing_ming) {
        this.xing_ming = xing_ming;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public Integer getNian_ling() {
        return nian_ling;
    }

    public void setNian_ling(Integer nian_ling) {
        this.nian_ling = nian_ling;
    }

    public String getXing_bei() {
        return xing_bei;
    }

    public void setXing_bei(String xing_bei) {
        this.xing_bei = xing_bei;
    }

    public String getMin_zu() {
        return min_zu;
    }

    public void setMin_zu(String min_zu) {
        this.min_zu = min_zu;
    }

    public String getZhu_zhi() {
        return zhu_zhi;
    }

    public void setZhu_zhi(String zhu_zhi) {
        this.zhu_zhi = zhu_zhi;
    }

    public String getDian_hua() {
        return dian_hua;
    }

    public void setDian_hua(String dian_hua) {
        this.dian_hua = dian_hua;
    }

    public String getXian_ju_zhu_di() {
        return xian_ju_zhu_di;
    }

    public void setXian_ju_zhu_di(String xian_ju_zhu_di) {
        this.xian_ju_zhu_di = xian_ju_zhu_di;
    }

    public String getFang_wu() {
        return fang_wu;
    }

    public void setFang_wu(String fang_wu) {
        this.fang_wu = fang_wu;
    }

    public String getBei_zhu() {
        return bei_zhu;
    }

    public void setBei_zhu(String bei_zhu) {
        this.bei_zhu = bei_zhu;
    }

    public Integer getShe_hao() {
        return she_hao;
    }

    public void setShe_hao(Integer she_hao) {
        this.she_hao = she_hao;
    }

    public Date getChuangjian_shijian() {
        return chuangjian_shijian;
    }

    public void setChuangjian_shijian(Date chuangjian_shijian) {
        this.chuangjian_shijian = chuangjian_shijian;
    }

    public Date getGengxin_shijian() {
        return gengxin_shijian;
    }

    public void setGengxin_shijian(Date gengxin_shijian) {
        this.gengxin_shijian = gengxin_shijian;
    }

    @Override
    public String toString() {
        return "PopulationEntity{" +
                "id=" + id +
                ", hu_hao='" + hu_hao + '\'' +
                ", yhzgx='" + yhzgx + '\'' +
                ", xing_ming='" + xing_ming + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", csrq='" + csrq + '\'' +
                ", xing_bei='" + xing_bei + '\'' +
                ", min_zu='" + min_zu + '\'' +
                ", zhu_zhi='" + zhu_zhi + '\'' +
                ", dian_hua='" + dian_hua + '\'' +
                ", xian_ju_zhu_di='" + xian_ju_zhu_di + '\'' +
                ", fang_wu='" + fang_wu + '\'' +
                ", bei_zhu='" + bei_zhu + '\'' +
                ", she_hao=" + she_hao +
                '}';
    }
}
