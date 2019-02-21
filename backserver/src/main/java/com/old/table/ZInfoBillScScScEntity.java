package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZInfoBillScScSc", schema = "dbo", catalog = "shaoxiongtest")
public class ZInfoBillScScScEntity {
    private int id;
    private Integer scid;
    private String liename;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "scid", nullable = true)
    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    @Basic
    @Column(name = "liename", nullable = true, length = 50)
    public String getLiename() {
        return liename;
    }

    public void setLiename(String liename) {
        this.liename = liename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZInfoBillScScScEntity that = (ZInfoBillScScScEntity) o;

        if (id != that.id) return false;
        if (scid != null ? !scid.equals(that.scid) : that.scid != null) return false;
        if (liename != null ? !liename.equals(that.liename) : that.liename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (scid != null ? scid.hashCode() : 0);
        result = 31 * result + (liename != null ? liename.hashCode() : 0);
        return result;
    }
}
