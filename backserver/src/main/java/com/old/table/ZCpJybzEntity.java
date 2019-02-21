package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZCpJybz", schema = "dbo", catalog = "shaoxiongtest")
public class ZCpJybzEntity {
    private int id;
    private String bzh;
    private String bzmc;
    private Integer zt;
    private Integer bm;
    private Integer lb;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bzh", nullable = true, length = 255)
    public String getBzh() {
        return bzh;
    }

    public void setBzh(String bzh) {
        this.bzh = bzh;
    }

    @Basic
    @Column(name = "bzmc", nullable = true, length = 255)
    public String getBzmc() {
        return bzmc;
    }

    public void setBzmc(String bzmc) {
        this.bzmc = bzmc;
    }

    @Basic
    @Column(name = "zt", nullable = true)
    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    @Basic
    @Column(name = "bm", nullable = true)
    public Integer getBm() {
        return bm;
    }

    public void setBm(Integer bm) {
        this.bm = bm;
    }

    @Basic
    @Column(name = "lb", nullable = true)
    public Integer getLb() {
        return lb;
    }

    public void setLb(Integer lb) {
        this.lb = lb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZCpJybzEntity that = (ZCpJybzEntity) o;

        if (id != that.id) return false;
        if (bzh != null ? !bzh.equals(that.bzh) : that.bzh != null) return false;
        if (bzmc != null ? !bzmc.equals(that.bzmc) : that.bzmc != null) return false;
        if (zt != null ? !zt.equals(that.zt) : that.zt != null) return false;
        if (bm != null ? !bm.equals(that.bm) : that.bm != null) return false;
        if (lb != null ? !lb.equals(that.lb) : that.lb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bzh != null ? bzh.hashCode() : 0);
        result = 31 * result + (bzmc != null ? bzmc.hashCode() : 0);
        result = 31 * result + (zt != null ? zt.hashCode() : 0);
        result = 31 * result + (bm != null ? bm.hashCode() : 0);
        result = 31 * result + (lb != null ? lb.hashCode() : 0);
        return result;
    }
}
