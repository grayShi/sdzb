package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZDept", schema = "dbo", catalog = "shaoxiongtest")
public class ZDeptEntity {
    private int id;
    private String deptname;
    private String deptsx;
    private String deptssjydwid;
    private String depttime;
    private Integer isqy;
    private Integer qxcs;
    private String deptnamelist;
    private Integer detnameid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "deptname", nullable = true, length = 50)
    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Basic
    @Column(name = "deptsx", nullable = true, length = 50)
    public String getDeptsx() {
        return deptsx;
    }

    public void setDeptsx(String deptsx) {
        this.deptsx = deptsx;
    }

    @Basic
    @Column(name = "deptssjydwid", nullable = true, length = 50)
    public String getDeptssjydwid() {
        return deptssjydwid;
    }

    public void setDeptssjydwid(String deptssjydwid) {
        this.deptssjydwid = deptssjydwid;
    }

    @Basic
    @Column(name = "depttime", nullable = true, length = 4)
    public String getDepttime() {
        return depttime;
    }

    public void setDepttime(String depttime) {
        this.depttime = depttime;
    }

    @Basic
    @Column(name = "isqy", nullable = true)
    public Integer getIsqy() {
        return isqy;
    }

    public void setIsqy(Integer isqy) {
        this.isqy = isqy;
    }

    @Basic
    @Column(name = "qxcs", nullable = true)
    public Integer getQxcs() {
        return qxcs;
    }

    public void setQxcs(Integer qxcs) {
        this.qxcs = qxcs;
    }

    @Basic
    @Column(name = "deptnamelist", nullable = true, length = 50)
    public String getDeptnamelist() {
        return deptnamelist;
    }

    public void setDeptnamelist(String deptnamelist) {
        this.deptnamelist = deptnamelist;
    }

    @Basic
    @Column(name = "detnameid", nullable = true)
    public Integer getDetnameid() {
        return detnameid;
    }

    public void setDetnameid(Integer detnameid) {
        this.detnameid = detnameid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZDeptEntity that = (ZDeptEntity) o;

        if (id != that.id) return false;
        if (deptname != null ? !deptname.equals(that.deptname) : that.deptname != null) return false;
        if (deptsx != null ? !deptsx.equals(that.deptsx) : that.deptsx != null) return false;
        if (deptssjydwid != null ? !deptssjydwid.equals(that.deptssjydwid) : that.deptssjydwid != null) return false;
        if (depttime != null ? !depttime.equals(that.depttime) : that.depttime != null) return false;
        if (isqy != null ? !isqy.equals(that.isqy) : that.isqy != null) return false;
        if (qxcs != null ? !qxcs.equals(that.qxcs) : that.qxcs != null) return false;
        if (deptnamelist != null ? !deptnamelist.equals(that.deptnamelist) : that.deptnamelist != null) return false;
        if (detnameid != null ? !detnameid.equals(that.detnameid) : that.detnameid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (deptname != null ? deptname.hashCode() : 0);
        result = 31 * result + (deptsx != null ? deptsx.hashCode() : 0);
        result = 31 * result + (deptssjydwid != null ? deptssjydwid.hashCode() : 0);
        result = 31 * result + (depttime != null ? depttime.hashCode() : 0);
        result = 31 * result + (isqy != null ? isqy.hashCode() : 0);
        result = 31 * result + (qxcs != null ? qxcs.hashCode() : 0);
        result = 31 * result + (deptnamelist != null ? deptnamelist.hashCode() : 0);
        result = 31 * result + (detnameid != null ? detnameid.hashCode() : 0);
        return result;
    }
}
