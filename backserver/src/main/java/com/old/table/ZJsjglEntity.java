package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZJsjgl", schema = "dbo", catalog = "shaoxiongtest")
public class ZJsjglEntity {
    private int id;
    private String bm;
    private String bgr;
    private String ipdz;
    private String macdz;
    private String jsjpp;
    private String jsjxh;
    private String jisjpz;
    private String jsjyt;
    private String jsjptyq;
    private String qtsm;
    private String lb;
    private String fjh;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bm", nullable = true, length = 50)
    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    @Basic
    @Column(name = "bgr", nullable = true, length = 50)
    public String getBgr() {
        return bgr;
    }

    public void setBgr(String bgr) {
        this.bgr = bgr;
    }

    @Basic
    @Column(name = "ipdz", nullable = true, length = 50)
    public String getIpdz() {
        return ipdz;
    }

    public void setIpdz(String ipdz) {
        this.ipdz = ipdz;
    }

    @Basic
    @Column(name = "macdz", nullable = true, length = 50)
    public String getMacdz() {
        return macdz;
    }

    public void setMacdz(String macdz) {
        this.macdz = macdz;
    }

    @Basic
    @Column(name = "jsjpp", nullable = true, length = 50)
    public String getJsjpp() {
        return jsjpp;
    }

    public void setJsjpp(String jsjpp) {
        this.jsjpp = jsjpp;
    }

    @Basic
    @Column(name = "jsjxh", nullable = true, length = 50)
    public String getJsjxh() {
        return jsjxh;
    }

    public void setJsjxh(String jsjxh) {
        this.jsjxh = jsjxh;
    }

    @Basic
    @Column(name = "jisjpz", nullable = true, length = 50)
    public String getJisjpz() {
        return jisjpz;
    }

    public void setJisjpz(String jisjpz) {
        this.jisjpz = jisjpz;
    }

    @Basic
    @Column(name = "jsjyt", nullable = true, length = 50)
    public String getJsjyt() {
        return jsjyt;
    }

    public void setJsjyt(String jsjyt) {
        this.jsjyt = jsjyt;
    }

    @Basic
    @Column(name = "jsjptyq", nullable = true, length = 2147483647)
    public String getJsjptyq() {
        return jsjptyq;
    }

    public void setJsjptyq(String jsjptyq) {
        this.jsjptyq = jsjptyq;
    }

    @Basic
    @Column(name = "qtsm", nullable = true, length = 2147483647)
    public String getQtsm() {
        return qtsm;
    }

    public void setQtsm(String qtsm) {
        this.qtsm = qtsm;
    }

    @Basic
    @Column(name = "lb", nullable = true, length = 50)
    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }

    @Basic
    @Column(name = "fjh", nullable = true, length = 50)
    public String getFjh() {
        return fjh;
    }

    public void setFjh(String fjh) {
        this.fjh = fjh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZJsjglEntity that = (ZJsjglEntity) o;

        if (id != that.id) return false;
        if (bm != null ? !bm.equals(that.bm) : that.bm != null) return false;
        if (bgr != null ? !bgr.equals(that.bgr) : that.bgr != null) return false;
        if (ipdz != null ? !ipdz.equals(that.ipdz) : that.ipdz != null) return false;
        if (macdz != null ? !macdz.equals(that.macdz) : that.macdz != null) return false;
        if (jsjpp != null ? !jsjpp.equals(that.jsjpp) : that.jsjpp != null) return false;
        if (jsjxh != null ? !jsjxh.equals(that.jsjxh) : that.jsjxh != null) return false;
        if (jisjpz != null ? !jisjpz.equals(that.jisjpz) : that.jisjpz != null) return false;
        if (jsjyt != null ? !jsjyt.equals(that.jsjyt) : that.jsjyt != null) return false;
        if (jsjptyq != null ? !jsjptyq.equals(that.jsjptyq) : that.jsjptyq != null) return false;
        if (qtsm != null ? !qtsm.equals(that.qtsm) : that.qtsm != null) return false;
        if (lb != null ? !lb.equals(that.lb) : that.lb != null) return false;
        if (fjh != null ? !fjh.equals(that.fjh) : that.fjh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bm != null ? bm.hashCode() : 0);
        result = 31 * result + (bgr != null ? bgr.hashCode() : 0);
        result = 31 * result + (ipdz != null ? ipdz.hashCode() : 0);
        result = 31 * result + (macdz != null ? macdz.hashCode() : 0);
        result = 31 * result + (jsjpp != null ? jsjpp.hashCode() : 0);
        result = 31 * result + (jsjxh != null ? jsjxh.hashCode() : 0);
        result = 31 * result + (jisjpz != null ? jisjpz.hashCode() : 0);
        result = 31 * result + (jsjyt != null ? jsjyt.hashCode() : 0);
        result = 31 * result + (jsjptyq != null ? jsjptyq.hashCode() : 0);
        result = 31 * result + (qtsm != null ? qtsm.hashCode() : 0);
        result = 31 * result + (lb != null ? lb.hashCode() : 0);
        result = 31 * result + (fjh != null ? fjh.hashCode() : 0);
        return result;
    }
}
