package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZInfoBillSc", schema = "dbo", catalog = "shaoxiongtest")
public class ZInfoBillScEntity {
    private int id;
    private Integer ypid;
    private Long rwid;
    private String ypjyhjwd;
    private String ypjyhjsd;
    private String ypjyhjqy;
    private Timestamp ypjcdateq;
    private Timestamp ypjcdatez;
    private String ypjybz;
    private String ypjyff;
    private String ypjyyq;
    private String ypjyjl;
    private Integer sfhg;
    private String bz;
    private Integer ypjydw;
    private String chimage;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ypid", nullable = true)
    public Integer getYpid() {
        return ypid;
    }

    public void setYpid(Integer ypid) {
        this.ypid = ypid;
    }

    @Basic
    @Column(name = "rwid", nullable = true)
    public Long getRwid() {
        return rwid;
    }

    public void setRwid(Long rwid) {
        this.rwid = rwid;
    }

    @Basic
    @Column(name = "ypjyhjwd", nullable = true, length = 50)
    public String getYpjyhjwd() {
        return ypjyhjwd;
    }

    public void setYpjyhjwd(String ypjyhjwd) {
        this.ypjyhjwd = ypjyhjwd;
    }

    @Basic
    @Column(name = "ypjyhjsd", nullable = true, length = 50)
    public String getYpjyhjsd() {
        return ypjyhjsd;
    }

    public void setYpjyhjsd(String ypjyhjsd) {
        this.ypjyhjsd = ypjyhjsd;
    }

    @Basic
    @Column(name = "ypjyhjqy", nullable = true, length = 50)
    public String getYpjyhjqy() {
        return ypjyhjqy;
    }

    public void setYpjyhjqy(String ypjyhjqy) {
        this.ypjyhjqy = ypjyhjqy;
    }

    @Basic
    @Column(name = "ypjcdateq", nullable = true)
    public Timestamp getYpjcdateq() {
        return ypjcdateq;
    }

    public void setYpjcdateq(Timestamp ypjcdateq) {
        this.ypjcdateq = ypjcdateq;
    }

    @Basic
    @Column(name = "ypjcdatez", nullable = true)
    public Timestamp getYpjcdatez() {
        return ypjcdatez;
    }

    public void setYpjcdatez(Timestamp ypjcdatez) {
        this.ypjcdatez = ypjcdatez;
    }

    @Basic
    @Column(name = "ypjybz", nullable = true, length = 2147483647)
    public String getYpjybz() {
        return ypjybz;
    }

    public void setYpjybz(String ypjybz) {
        this.ypjybz = ypjybz;
    }

    @Basic
    @Column(name = "ypjyff", nullable = true, length = 2147483647)
    public String getYpjyff() {
        return ypjyff;
    }

    public void setYpjyff(String ypjyff) {
        this.ypjyff = ypjyff;
    }

    @Basic
    @Column(name = "ypjyyq", nullable = true, length = 2147483647)
    public String getYpjyyq() {
        return ypjyyq;
    }

    public void setYpjyyq(String ypjyyq) {
        this.ypjyyq = ypjyyq;
    }

    @Basic
    @Column(name = "ypjyjl", nullable = true, length = 2147483647)
    public String getYpjyjl() {
        return ypjyjl;
    }

    public void setYpjyjl(String ypjyjl) {
        this.ypjyjl = ypjyjl;
    }

    @Basic
    @Column(name = "sfhg", nullable = true)
    public Integer getSfhg() {
        return sfhg;
    }

    public void setSfhg(Integer sfhg) {
        this.sfhg = sfhg;
    }

    @Basic
    @Column(name = "bz", nullable = true, length = 2147483647)
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Basic
    @Column(name = "ypjydw", nullable = true)
    public Integer getYpjydw() {
        return ypjydw;
    }

    public void setYpjydw(Integer ypjydw) {
        this.ypjydw = ypjydw;
    }

    @Basic
    @Column(name = "chimage", nullable = true, length = 50)
    public String getChimage() {
        return chimage;
    }

    public void setChimage(String chimage) {
        this.chimage = chimage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZInfoBillScEntity that = (ZInfoBillScEntity) o;

        if (id != that.id) return false;
        if (ypid != null ? !ypid.equals(that.ypid) : that.ypid != null) return false;
        if (rwid != null ? !rwid.equals(that.rwid) : that.rwid != null) return false;
        if (ypjyhjwd != null ? !ypjyhjwd.equals(that.ypjyhjwd) : that.ypjyhjwd != null) return false;
        if (ypjyhjsd != null ? !ypjyhjsd.equals(that.ypjyhjsd) : that.ypjyhjsd != null) return false;
        if (ypjyhjqy != null ? !ypjyhjqy.equals(that.ypjyhjqy) : that.ypjyhjqy != null) return false;
        if (ypjcdateq != null ? !ypjcdateq.equals(that.ypjcdateq) : that.ypjcdateq != null) return false;
        if (ypjcdatez != null ? !ypjcdatez.equals(that.ypjcdatez) : that.ypjcdatez != null) return false;
        if (ypjybz != null ? !ypjybz.equals(that.ypjybz) : that.ypjybz != null) return false;
        if (ypjyff != null ? !ypjyff.equals(that.ypjyff) : that.ypjyff != null) return false;
        if (ypjyyq != null ? !ypjyyq.equals(that.ypjyyq) : that.ypjyyq != null) return false;
        if (ypjyjl != null ? !ypjyjl.equals(that.ypjyjl) : that.ypjyjl != null) return false;
        if (sfhg != null ? !sfhg.equals(that.sfhg) : that.sfhg != null) return false;
        if (bz != null ? !bz.equals(that.bz) : that.bz != null) return false;
        if (ypjydw != null ? !ypjydw.equals(that.ypjydw) : that.ypjydw != null) return false;
        if (chimage != null ? !chimage.equals(that.chimage) : that.chimage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ypid != null ? ypid.hashCode() : 0);
        result = 31 * result + (rwid != null ? rwid.hashCode() : 0);
        result = 31 * result + (ypjyhjwd != null ? ypjyhjwd.hashCode() : 0);
        result = 31 * result + (ypjyhjsd != null ? ypjyhjsd.hashCode() : 0);
        result = 31 * result + (ypjyhjqy != null ? ypjyhjqy.hashCode() : 0);
        result = 31 * result + (ypjcdateq != null ? ypjcdateq.hashCode() : 0);
        result = 31 * result + (ypjcdatez != null ? ypjcdatez.hashCode() : 0);
        result = 31 * result + (ypjybz != null ? ypjybz.hashCode() : 0);
        result = 31 * result + (ypjyff != null ? ypjyff.hashCode() : 0);
        result = 31 * result + (ypjyyq != null ? ypjyyq.hashCode() : 0);
        result = 31 * result + (ypjyjl != null ? ypjyjl.hashCode() : 0);
        result = 31 * result + (sfhg != null ? sfhg.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        result = 31 * result + (ypjydw != null ? ypjydw.hashCode() : 0);
        result = 31 * result + (chimage != null ? chimage.hashCode() : 0);
        return result;
    }
}
