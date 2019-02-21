package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZNxqx", schema = "dbo", catalog = "shaoxiongtest")
public class ZNxqxEntity {
    private int id;
    private Integer userid;
    private Integer nxid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "nxid", nullable = true)
    public Integer getNxid() {
        return nxid;
    }

    public void setNxid(Integer nxid) {
        this.nxid = nxid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZNxqxEntity that = (ZNxqxEntity) o;

        if (id != that.id) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (nxid != null ? !nxid.equals(that.nxid) : that.nxid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (nxid != null ? nxid.hashCode() : 0);
        return result;
    }
}
