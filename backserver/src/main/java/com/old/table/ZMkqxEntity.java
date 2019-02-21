package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZMkqx", schema = "dbo", catalog = "shaoxiongtest")
public class ZMkqxEntity {
    private int id;
    private Integer userid;
    private Integer mkid;

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
    @Column(name = "mkid", nullable = true)
    public Integer getMkid() {
        return mkid;
    }

    public void setMkid(Integer mkid) {
        this.mkid = mkid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZMkqxEntity that = (ZMkqxEntity) o;

        if (id != that.id) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (mkid != null ? !mkid.equals(that.mkid) : that.mkid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (mkid != null ? mkid.hashCode() : 0);
        return result;
    }
}
