package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZWjlb", schema = "dbo", catalog = "shaoxiongtest")
public class ZWjlbEntity {
    private int id;
    private String wjlbname;
    private Integer superid;
    private Integer xuhao;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wjlbname", nullable = true, length = 50)
    public String getWjlbname() {
        return wjlbname;
    }

    public void setWjlbname(String wjlbname) {
        this.wjlbname = wjlbname;
    }

    @Basic
    @Column(name = "superid", nullable = true)
    public Integer getSuperid() {
        return superid;
    }

    public void setSuperid(Integer superid) {
        this.superid = superid;
    }

    @Basic
    @Column(name = "xuhao", nullable = true)
    public Integer getXuhao() {
        return xuhao;
    }

    public void setXuhao(Integer xuhao) {
        this.xuhao = xuhao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZWjlbEntity that = (ZWjlbEntity) o;

        if (id != that.id) return false;
        if (wjlbname != null ? !wjlbname.equals(that.wjlbname) : that.wjlbname != null) return false;
        if (superid != null ? !superid.equals(that.superid) : that.superid != null) return false;
        if (xuhao != null ? !xuhao.equals(that.xuhao) : that.xuhao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (wjlbname != null ? wjlbname.hashCode() : 0);
        result = 31 * result + (superid != null ? superid.hashCode() : 0);
        result = 31 * result + (xuhao != null ? xuhao.hashCode() : 0);
        return result;
    }
}
