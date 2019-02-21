package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "ZGlrMsg", schema = "dbo", catalog = "shaoxiongtest")
public class ZGlrMsgEntity {
    private int id;
    private Integer ypid;
    private Integer glrid;
    private Date gldate;
    private Integer glqxr;
    private Date glqxdate;

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
    @Column(name = "glrid", nullable = true)
    public Integer getGlrid() {
        return glrid;
    }

    public void setGlrid(Integer glrid) {
        this.glrid = glrid;
    }

    @Basic
    @Column(name = "gldate", nullable = true)
    public Date getGldate() {
        return gldate;
    }

    public void setGldate(Date gldate) {
        this.gldate = gldate;
    }

    @Basic
    @Column(name = "glqxr", nullable = true)
    public Integer getGlqxr() {
        return glqxr;
    }

    public void setGlqxr(Integer glqxr) {
        this.glqxr = glqxr;
    }

    @Basic
    @Column(name = "glqxdate", nullable = true)
    public Date getGlqxdate() {
        return glqxdate;
    }

    public void setGlqxdate(Date glqxdate) {
        this.glqxdate = glqxdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZGlrMsgEntity that = (ZGlrMsgEntity) o;

        if (id != that.id) return false;
        if (ypid != null ? !ypid.equals(that.ypid) : that.ypid != null) return false;
        if (glrid != null ? !glrid.equals(that.glrid) : that.glrid != null) return false;
        if (gldate != null ? !gldate.equals(that.gldate) : that.gldate != null) return false;
        if (glqxr != null ? !glqxr.equals(that.glqxr) : that.glqxr != null) return false;
        if (glqxdate != null ? !glqxdate.equals(that.glqxdate) : that.glqxdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ypid != null ? ypid.hashCode() : 0);
        result = 31 * result + (glrid != null ? glrid.hashCode() : 0);
        result = 31 * result + (gldate != null ? gldate.hashCode() : 0);
        result = 31 * result + (glqxr != null ? glqxr.hashCode() : 0);
        result = 31 * result + (glqxdate != null ? glqxdate.hashCode() : 0);
        return result;
    }
}
