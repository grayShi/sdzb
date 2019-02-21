package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "ZBgSfxxMsg", schema = "dbo", catalog = "shaoxiongtest")
public class ZBgSfxxMsgEntity {
    private int id;
    private String qyid;
    private BigDecimal je;
    private Integer sfxm;
    private String fph;
    private Timestamp sfdate;
    private Integer sfbmid;
    private Integer sfshflag;
    private Integer sffs;
    private String sfdz;
    private String bh;
    private String skdw;
    private String bz;
    private Timestamp kpdate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "qyid", nullable = true, length = 50)
    public String getQyid() {
        return qyid;
    }

    public void setQyid(String qyid) {
        this.qyid = qyid;
    }

    @Basic
    @Column(name = "je", nullable = true, precision = 2)
    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    @Basic
    @Column(name = "sfxm", nullable = true)
    public Integer getSfxm() {
        return sfxm;
    }

    public void setSfxm(Integer sfxm) {
        this.sfxm = sfxm;
    }

    @Basic
    @Column(name = "fph", nullable = true, length = 50)
    public String getFph() {
        return fph;
    }

    public void setFph(String fph) {
        this.fph = fph;
    }

    @Basic
    @Column(name = "sfdate", nullable = true)
    public Timestamp getSfdate() {
        return sfdate;
    }

    public void setSfdate(Timestamp sfdate) {
        this.sfdate = sfdate;
    }

    @Basic
    @Column(name = "sfbmid", nullable = true)
    public Integer getSfbmid() {
        return sfbmid;
    }

    public void setSfbmid(Integer sfbmid) {
        this.sfbmid = sfbmid;
    }

    @Basic
    @Column(name = "sfshflag", nullable = true)
    public Integer getSfshflag() {
        return sfshflag;
    }

    public void setSfshflag(Integer sfshflag) {
        this.sfshflag = sfshflag;
    }

    @Basic
    @Column(name = "sffs", nullable = true)
    public Integer getSffs() {
        return sffs;
    }

    public void setSffs(Integer sffs) {
        this.sffs = sffs;
    }

    @Basic
    @Column(name = "sfdz", nullable = true, length = 50)
    public String getSfdz() {
        return sfdz;
    }

    public void setSfdz(String sfdz) {
        this.sfdz = sfdz;
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
    @Column(name = "skdw", nullable = true, length = 100)
    public String getSkdw() {
        return skdw;
    }

    public void setSkdw(String skdw) {
        this.skdw = skdw;
    }

    @Basic
    @Column(name = "bz", nullable = true, length = 300)
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Basic
    @Column(name = "kpdate", nullable = true)
    public Timestamp getKpdate() {
        return kpdate;
    }

    public void setKpdate(Timestamp kpdate) {
        this.kpdate = kpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZBgSfxxMsgEntity that = (ZBgSfxxMsgEntity) o;

        if (id != that.id) return false;
        if (qyid != null ? !qyid.equals(that.qyid) : that.qyid != null) return false;
        if (je != null ? !je.equals(that.je) : that.je != null) return false;
        if (sfxm != null ? !sfxm.equals(that.sfxm) : that.sfxm != null) return false;
        if (fph != null ? !fph.equals(that.fph) : that.fph != null) return false;
        if (sfdate != null ? !sfdate.equals(that.sfdate) : that.sfdate != null) return false;
        if (sfbmid != null ? !sfbmid.equals(that.sfbmid) : that.sfbmid != null) return false;
        if (sfshflag != null ? !sfshflag.equals(that.sfshflag) : that.sfshflag != null) return false;
        if (sffs != null ? !sffs.equals(that.sffs) : that.sffs != null) return false;
        if (sfdz != null ? !sfdz.equals(that.sfdz) : that.sfdz != null) return false;
        if (bh != null ? !bh.equals(that.bh) : that.bh != null) return false;
        if (skdw != null ? !skdw.equals(that.skdw) : that.skdw != null) return false;
        if (bz != null ? !bz.equals(that.bz) : that.bz != null) return false;
        if (kpdate != null ? !kpdate.equals(that.kpdate) : that.kpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (qyid != null ? qyid.hashCode() : 0);
        result = 31 * result + (je != null ? je.hashCode() : 0);
        result = 31 * result + (sfxm != null ? sfxm.hashCode() : 0);
        result = 31 * result + (fph != null ? fph.hashCode() : 0);
        result = 31 * result + (sfdate != null ? sfdate.hashCode() : 0);
        result = 31 * result + (sfbmid != null ? sfbmid.hashCode() : 0);
        result = 31 * result + (sfshflag != null ? sfshflag.hashCode() : 0);
        result = 31 * result + (sffs != null ? sffs.hashCode() : 0);
        result = 31 * result + (sfdz != null ? sfdz.hashCode() : 0);
        result = 31 * result + (bh != null ? bh.hashCode() : 0);
        result = 31 * result + (skdw != null ? skdw.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        result = 31 * result + (kpdate != null ? kpdate.hashCode() : 0);
        return result;
    }
}
