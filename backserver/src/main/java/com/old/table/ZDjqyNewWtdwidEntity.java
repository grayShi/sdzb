package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZDjqyNew_wtdwid", schema = "dbo", catalog = "shaoxiongtest")
public class ZDjqyNewWtdwidEntity {
    private int id;
    private Integer ywid;
    private Integer qyid;
    private String qyname;
    private String cpmc;
    private String cpdm;
    private String zxbz;
    private String qydm;
    private String qydz;
    private String pc;
    private Integer bm;
    private String qxdz;
    private Integer djflag;
    private String lxr;
    private String dh;
    private String yb;
    private String djnf;
    private String sbnzt;
    private String xbnzt;
    private String byziduan;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Ywid", nullable = true)
    public Integer getYwid() {
        return ywid;
    }

    public void setYwid(Integer ywid) {
        this.ywid = ywid;
    }

    @Basic
    @Column(name = "qyid", nullable = true)
    public Integer getQyid() {
        return qyid;
    }

    public void setQyid(Integer qyid) {
        this.qyid = qyid;
    }

    @Basic
    @Column(name = "qyname", nullable = true, length = 300)
    public String getQyname() {
        return qyname;
    }

    public void setQyname(String qyname) {
        this.qyname = qyname;
    }

    @Basic
    @Column(name = "cpmc", nullable = true, length = 300)
    public String getCpmc() {
        return cpmc;
    }

    public void setCpmc(String cpmc) {
        this.cpmc = cpmc;
    }

    @Basic
    @Column(name = "cpdm", nullable = true, length = 300)
    public String getCpdm() {
        return cpdm;
    }

    public void setCpdm(String cpdm) {
        this.cpdm = cpdm;
    }

    @Basic
    @Column(name = "zxbz", nullable = true, length = 300)
    public String getZxbz() {
        return zxbz;
    }

    public void setZxbz(String zxbz) {
        this.zxbz = zxbz;
    }

    @Basic
    @Column(name = "qydm", nullable = true, length = 50)
    public String getQydm() {
        return qydm;
    }

    public void setQydm(String qydm) {
        this.qydm = qydm;
    }

    @Basic
    @Column(name = "qydz", nullable = true, length = 300)
    public String getQydz() {
        return qydz;
    }

    public void setQydz(String qydz) {
        this.qydz = qydz;
    }

    @Basic
    @Column(name = "pc", nullable = true, length = 50)
    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
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
    @Column(name = "qxdz", nullable = true, length = 100)
    public String getQxdz() {
        return qxdz;
    }

    public void setQxdz(String qxdz) {
        this.qxdz = qxdz;
    }

    @Basic
    @Column(name = "djflag", nullable = true)
    public Integer getDjflag() {
        return djflag;
    }

    public void setDjflag(Integer djflag) {
        this.djflag = djflag;
    }

    @Basic
    @Column(name = "lxr", nullable = true, length = 50)
    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    @Basic
    @Column(name = "dh", nullable = true, length = 50)
    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    @Basic
    @Column(name = "yb", nullable = true, length = 50)
    public String getYb() {
        return yb;
    }

    public void setYb(String yb) {
        this.yb = yb;
    }

    @Basic
    @Column(name = "djnf", nullable = true, length = 10)
    public String getDjnf() {
        return djnf;
    }

    public void setDjnf(String djnf) {
        this.djnf = djnf;
    }

    @Basic
    @Column(name = "sbnzt", nullable = true, length = 50)
    public String getSbnzt() {
        return sbnzt;
    }

    public void setSbnzt(String sbnzt) {
        this.sbnzt = sbnzt;
    }

    @Basic
    @Column(name = "xbnzt", nullable = true, length = 50)
    public String getXbnzt() {
        return xbnzt;
    }

    public void setXbnzt(String xbnzt) {
        this.xbnzt = xbnzt;
    }

    @Basic
    @Column(name = "byziduan", nullable = true, length = 50)
    public String getByziduan() {
        return byziduan;
    }

    public void setByziduan(String byziduan) {
        this.byziduan = byziduan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZDjqyNewWtdwidEntity that = (ZDjqyNewWtdwidEntity) o;

        if (id != that.id) return false;
        if (ywid != null ? !ywid.equals(that.ywid) : that.ywid != null) return false;
        if (qyid != null ? !qyid.equals(that.qyid) : that.qyid != null) return false;
        if (qyname != null ? !qyname.equals(that.qyname) : that.qyname != null) return false;
        if (cpmc != null ? !cpmc.equals(that.cpmc) : that.cpmc != null) return false;
        if (cpdm != null ? !cpdm.equals(that.cpdm) : that.cpdm != null) return false;
        if (zxbz != null ? !zxbz.equals(that.zxbz) : that.zxbz != null) return false;
        if (qydm != null ? !qydm.equals(that.qydm) : that.qydm != null) return false;
        if (qydz != null ? !qydz.equals(that.qydz) : that.qydz != null) return false;
        if (pc != null ? !pc.equals(that.pc) : that.pc != null) return false;
        if (bm != null ? !bm.equals(that.bm) : that.bm != null) return false;
        if (qxdz != null ? !qxdz.equals(that.qxdz) : that.qxdz != null) return false;
        if (djflag != null ? !djflag.equals(that.djflag) : that.djflag != null) return false;
        if (lxr != null ? !lxr.equals(that.lxr) : that.lxr != null) return false;
        if (dh != null ? !dh.equals(that.dh) : that.dh != null) return false;
        if (yb != null ? !yb.equals(that.yb) : that.yb != null) return false;
        if (djnf != null ? !djnf.equals(that.djnf) : that.djnf != null) return false;
        if (sbnzt != null ? !sbnzt.equals(that.sbnzt) : that.sbnzt != null) return false;
        if (xbnzt != null ? !xbnzt.equals(that.xbnzt) : that.xbnzt != null) return false;
        if (byziduan != null ? !byziduan.equals(that.byziduan) : that.byziduan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ywid != null ? ywid.hashCode() : 0);
        result = 31 * result + (qyid != null ? qyid.hashCode() : 0);
        result = 31 * result + (qyname != null ? qyname.hashCode() : 0);
        result = 31 * result + (cpmc != null ? cpmc.hashCode() : 0);
        result = 31 * result + (cpdm != null ? cpdm.hashCode() : 0);
        result = 31 * result + (zxbz != null ? zxbz.hashCode() : 0);
        result = 31 * result + (qydm != null ? qydm.hashCode() : 0);
        result = 31 * result + (qydz != null ? qydz.hashCode() : 0);
        result = 31 * result + (pc != null ? pc.hashCode() : 0);
        result = 31 * result + (bm != null ? bm.hashCode() : 0);
        result = 31 * result + (qxdz != null ? qxdz.hashCode() : 0);
        result = 31 * result + (djflag != null ? djflag.hashCode() : 0);
        result = 31 * result + (lxr != null ? lxr.hashCode() : 0);
        result = 31 * result + (dh != null ? dh.hashCode() : 0);
        result = 31 * result + (yb != null ? yb.hashCode() : 0);
        result = 31 * result + (djnf != null ? djnf.hashCode() : 0);
        result = 31 * result + (sbnzt != null ? sbnzt.hashCode() : 0);
        result = 31 * result + (xbnzt != null ? xbnzt.hashCode() : 0);
        result = 31 * result + (byziduan != null ? byziduan.hashCode() : 0);
        return result;
    }
}
