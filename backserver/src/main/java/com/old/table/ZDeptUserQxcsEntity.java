package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZDeptUserQxcs", schema = "dbo", catalog = "shaoxiongtest")
public class ZDeptUserQxcsEntity {
    private int id;
    private int ywxxid;
    private int userid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ywxxid", nullable = false)
    public int getYwxxid() {
        return ywxxid;
    }

    public void setYwxxid(int ywxxid) {
        this.ywxxid = ywxxid;
    }

    @Basic
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZDeptUserQxcsEntity that = (ZDeptUserQxcsEntity) o;

        if (id != that.id) return false;
        if (ywxxid != that.ywxxid) return false;
        if (userid != that.userid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + ywxxid;
        result = 31 * result + userid;
        return result;
    }
}
