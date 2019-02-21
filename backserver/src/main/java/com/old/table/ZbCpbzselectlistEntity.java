package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZBCpbzselectlist", schema = "dbo", catalog = "shaoxiongtest")
public class ZbCpbzselectlistEntity {
    private int id;
    private Integer ypid;
    private String bzh;

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
    @Column(name = "bzh", nullable = true, length = 50)
    public String getBzh() {
        return bzh;
    }

    public void setBzh(String bzh) {
        this.bzh = bzh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZbCpbzselectlistEntity that = (ZbCpbzselectlistEntity) o;

        if (id != that.id) return false;
        if (ypid != null ? !ypid.equals(that.ypid) : that.ypid != null) return false;
        if (bzh != null ? !bzh.equals(that.bzh) : that.bzh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ypid != null ? ypid.hashCode() : 0);
        result = 31 * result + (bzh != null ? bzh.hashCode() : 0);
        return result;
    }
}
