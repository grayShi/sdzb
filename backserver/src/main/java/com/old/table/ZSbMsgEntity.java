package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZSbMsg", schema = "dbo", catalog = "shaoxiongtest")
public class ZSbMsgEntity {
    private int id;
    private String bh;
    private String name;
    private String xn;
    private String lc;
    private String zqd;
    private String fbl;
    private String zzcm;
    private String zyyt;
    private String ccbh;
    private String sbyz;
    private Timestamp gjrq;
    private Integer jdzq;
    private String jddw;
    private String bgr;
    private String zt;
    private String gzs;
    private String cfd;
    private String jylx;
    private Timestamp jyrq;
    private Timestamp xcjyrq;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bh", nullable = true, length = 50)
    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "xn", nullable = true, length = 50)
    public String getXn() {
        return xn;
    }

    public void setXn(String xn) {
        this.xn = xn;
    }

    @Basic
    @Column(name = "lc", nullable = true, length = 50)
    public String getLc() {
        return lc;
    }

    public void setLc(String lc) {
        this.lc = lc;
    }

    @Basic
    @Column(name = "zqd", nullable = true, length = 50)
    public String getZqd() {
        return zqd;
    }

    public void setZqd(String zqd) {
        this.zqd = zqd;
    }

    @Basic
    @Column(name = "fbl", nullable = true, length = 50)
    public String getFbl() {
        return fbl;
    }

    public void setFbl(String fbl) {
        this.fbl = fbl;
    }

    @Basic
    @Column(name = "zzcm", nullable = true, length = 50)
    public String getZzcm() {
        return zzcm;
    }

    public void setZzcm(String zzcm) {
        this.zzcm = zzcm;
    }

    @Basic
    @Column(name = "zyyt", nullable = true, length = 50)
    public String getZyyt() {
        return zyyt;
    }

    public void setZyyt(String zyyt) {
        this.zyyt = zyyt;
    }

    @Basic
    @Column(name = "ccbh", nullable = true, length = 50)
    public String getCcbh() {
        return ccbh;
    }

    public void setCcbh(String ccbh) {
        this.ccbh = ccbh;
    }

    @Basic
    @Column(name = "sbyz", nullable = true, length = 50)
    public String getSbyz() {
        return sbyz;
    }

    public void setSbyz(String sbyz) {
        this.sbyz = sbyz;
    }

    @Basic
    @Column(name = "gjrq", nullable = true)
    public Timestamp getGjrq() {
        return gjrq;
    }

    public void setGjrq(Timestamp gjrq) {
        this.gjrq = gjrq;
    }

    @Basic
    @Column(name = "jdzq", nullable = true)
    public Integer getJdzq() {
        return jdzq;
    }

    public void setJdzq(Integer jdzq) {
        this.jdzq = jdzq;
    }

    @Basic
    @Column(name = "jddw", nullable = true, length = 50)
    public String getJddw() {
        return jddw;
    }

    public void setJddw(String jddw) {
        this.jddw = jddw;
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
    @Column(name = "zt", nullable = true, length = 50)
    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    @Basic
    @Column(name = "gzs", nullable = true, length = 50)
    public String getGzs() {
        return gzs;
    }

    public void setGzs(String gzs) {
        this.gzs = gzs;
    }

    @Basic
    @Column(name = "cfd", nullable = true, length = 50)
    public String getCfd() {
        return cfd;
    }

    public void setCfd(String cfd) {
        this.cfd = cfd;
    }

    @Basic
    @Column(name = "jylx", nullable = true, length = 50)
    public String getJylx() {
        return jylx;
    }

    public void setJylx(String jylx) {
        this.jylx = jylx;
    }

    @Basic
    @Column(name = "jyrq", nullable = true)
    public Timestamp getJyrq() {
        return jyrq;
    }

    public void setJyrq(Timestamp jyrq) {
        this.jyrq = jyrq;
    }

    @Basic
    @Column(name = "xcjyrq", nullable = true)
    public Timestamp getXcjyrq() {
        return xcjyrq;
    }

    public void setXcjyrq(Timestamp xcjyrq) {
        this.xcjyrq = xcjyrq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZSbMsgEntity that = (ZSbMsgEntity) o;

        if (id != that.id) return false;
        if (bh != null ? !bh.equals(that.bh) : that.bh != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (xn != null ? !xn.equals(that.xn) : that.xn != null) return false;
        if (lc != null ? !lc.equals(that.lc) : that.lc != null) return false;
        if (zqd != null ? !zqd.equals(that.zqd) : that.zqd != null) return false;
        if (fbl != null ? !fbl.equals(that.fbl) : that.fbl != null) return false;
        if (zzcm != null ? !zzcm.equals(that.zzcm) : that.zzcm != null) return false;
        if (zyyt != null ? !zyyt.equals(that.zyyt) : that.zyyt != null) return false;
        if (ccbh != null ? !ccbh.equals(that.ccbh) : that.ccbh != null) return false;
        if (sbyz != null ? !sbyz.equals(that.sbyz) : that.sbyz != null) return false;
        if (gjrq != null ? !gjrq.equals(that.gjrq) : that.gjrq != null) return false;
        if (jdzq != null ? !jdzq.equals(that.jdzq) : that.jdzq != null) return false;
        if (jddw != null ? !jddw.equals(that.jddw) : that.jddw != null) return false;
        if (bgr != null ? !bgr.equals(that.bgr) : that.bgr != null) return false;
        if (zt != null ? !zt.equals(that.zt) : that.zt != null) return false;
        if (gzs != null ? !gzs.equals(that.gzs) : that.gzs != null) return false;
        if (cfd != null ? !cfd.equals(that.cfd) : that.cfd != null) return false;
        if (jylx != null ? !jylx.equals(that.jylx) : that.jylx != null) return false;
        if (jyrq != null ? !jyrq.equals(that.jyrq) : that.jyrq != null) return false;
        if (xcjyrq != null ? !xcjyrq.equals(that.xcjyrq) : that.xcjyrq != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bh != null ? bh.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (xn != null ? xn.hashCode() : 0);
        result = 31 * result + (lc != null ? lc.hashCode() : 0);
        result = 31 * result + (zqd != null ? zqd.hashCode() : 0);
        result = 31 * result + (fbl != null ? fbl.hashCode() : 0);
        result = 31 * result + (zzcm != null ? zzcm.hashCode() : 0);
        result = 31 * result + (zyyt != null ? zyyt.hashCode() : 0);
        result = 31 * result + (ccbh != null ? ccbh.hashCode() : 0);
        result = 31 * result + (sbyz != null ? sbyz.hashCode() : 0);
        result = 31 * result + (gjrq != null ? gjrq.hashCode() : 0);
        result = 31 * result + (jdzq != null ? jdzq.hashCode() : 0);
        result = 31 * result + (jddw != null ? jddw.hashCode() : 0);
        result = 31 * result + (bgr != null ? bgr.hashCode() : 0);
        result = 31 * result + (zt != null ? zt.hashCode() : 0);
        result = 31 * result + (gzs != null ? gzs.hashCode() : 0);
        result = 31 * result + (cfd != null ? cfd.hashCode() : 0);
        result = 31 * result + (jylx != null ? jylx.hashCode() : 0);
        result = 31 * result + (jyrq != null ? jyrq.hashCode() : 0);
        result = 31 * result + (xcjyrq != null ? xcjyrq.hashCode() : 0);
        return result;
    }
}
