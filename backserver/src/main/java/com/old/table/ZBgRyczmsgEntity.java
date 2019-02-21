package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZBgRyczmsg", schema = "dbo", catalog = "shaoxiongtest")
public class ZBgRyczmsgEntity {
    private int id;
    private Integer ypId;
    private Integer zjrname;
    private Timestamp zjrdate;
    private Integer jhrname;
    private Timestamp jhrdate;
    private Integer pzrname;
    private Timestamp pzrdate;
    private Integer lyrname;
    private Timestamp lyrdate;
    private Integer tyrname;
    private Timestamp tyrdate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "YpID", nullable = true)
    public Integer getYpId() {
        return ypId;
    }

    public void setYpId(Integer ypId) {
        this.ypId = ypId;
    }

    @Basic
    @Column(name = "zjrname", nullable = true)
    public Integer getZjrname() {
        return zjrname;
    }

    public void setZjrname(Integer zjrname) {
        this.zjrname = zjrname;
    }

    @Basic
    @Column(name = "zjrdate", nullable = true)
    public Timestamp getZjrdate() {
        return zjrdate;
    }

    public void setZjrdate(Timestamp zjrdate) {
        this.zjrdate = zjrdate;
    }

    @Basic
    @Column(name = "jhrname", nullable = true)
    public Integer getJhrname() {
        return jhrname;
    }

    public void setJhrname(Integer jhrname) {
        this.jhrname = jhrname;
    }

    @Basic
    @Column(name = "jhrdate", nullable = true)
    public Timestamp getJhrdate() {
        return jhrdate;
    }

    public void setJhrdate(Timestamp jhrdate) {
        this.jhrdate = jhrdate;
    }

    @Basic
    @Column(name = "pzrname", nullable = true)
    public Integer getPzrname() {
        return pzrname;
    }

    public void setPzrname(Integer pzrname) {
        this.pzrname = pzrname;
    }

    @Basic
    @Column(name = "pzrdate", nullable = true)
    public Timestamp getPzrdate() {
        return pzrdate;
    }

    public void setPzrdate(Timestamp pzrdate) {
        this.pzrdate = pzrdate;
    }

    @Basic
    @Column(name = "lyrname", nullable = true)
    public Integer getLyrname() {
        return lyrname;
    }

    public void setLyrname(Integer lyrname) {
        this.lyrname = lyrname;
    }

    @Basic
    @Column(name = "lyrdate", nullable = true)
    public Timestamp getLyrdate() {
        return lyrdate;
    }

    public void setLyrdate(Timestamp lyrdate) {
        this.lyrdate = lyrdate;
    }

    @Basic
    @Column(name = "tyrname", nullable = true)
    public Integer getTyrname() {
        return tyrname;
    }

    public void setTyrname(Integer tyrname) {
        this.tyrname = tyrname;
    }

    @Basic
    @Column(name = "tyrdate", nullable = true)
    public Timestamp getTyrdate() {
        return tyrdate;
    }

    public void setTyrdate(Timestamp tyrdate) {
        this.tyrdate = tyrdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZBgRyczmsgEntity that = (ZBgRyczmsgEntity) o;

        if (id != that.id) return false;
        if (ypId != null ? !ypId.equals(that.ypId) : that.ypId != null) return false;
        if (zjrname != null ? !zjrname.equals(that.zjrname) : that.zjrname != null) return false;
        if (zjrdate != null ? !zjrdate.equals(that.zjrdate) : that.zjrdate != null) return false;
        if (jhrname != null ? !jhrname.equals(that.jhrname) : that.jhrname != null) return false;
        if (jhrdate != null ? !jhrdate.equals(that.jhrdate) : that.jhrdate != null) return false;
        if (pzrname != null ? !pzrname.equals(that.pzrname) : that.pzrname != null) return false;
        if (pzrdate != null ? !pzrdate.equals(that.pzrdate) : that.pzrdate != null) return false;
        if (lyrname != null ? !lyrname.equals(that.lyrname) : that.lyrname != null) return false;
        if (lyrdate != null ? !lyrdate.equals(that.lyrdate) : that.lyrdate != null) return false;
        if (tyrname != null ? !tyrname.equals(that.tyrname) : that.tyrname != null) return false;
        if (tyrdate != null ? !tyrdate.equals(that.tyrdate) : that.tyrdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ypId != null ? ypId.hashCode() : 0);
        result = 31 * result + (zjrname != null ? zjrname.hashCode() : 0);
        result = 31 * result + (zjrdate != null ? zjrdate.hashCode() : 0);
        result = 31 * result + (jhrname != null ? jhrname.hashCode() : 0);
        result = 31 * result + (jhrdate != null ? jhrdate.hashCode() : 0);
        result = 31 * result + (pzrname != null ? pzrname.hashCode() : 0);
        result = 31 * result + (pzrdate != null ? pzrdate.hashCode() : 0);
        result = 31 * result + (lyrname != null ? lyrname.hashCode() : 0);
        result = 31 * result + (lyrdate != null ? lyrdate.hashCode() : 0);
        result = 31 * result + (tyrname != null ? tyrname.hashCode() : 0);
        result = 31 * result + (tyrdate != null ? tyrdate.hashCode() : 0);
        return result;
    }
}
