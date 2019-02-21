package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZySate", schema = "dbo", catalog = "shaoxiongtest")
public class ZySateEntity {
    private int id;
    private String ypstatename;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ypstatename", nullable = true, length = 50)
    public String getYpstatename() {
        return ypstatename;
    }

    public void setYpstatename(String ypstatename) {
        this.ypstatename = ypstatename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZySateEntity that = (ZySateEntity) o;

        if (id != that.id) return false;
        if (ypstatename != null ? !ypstatename.equals(that.ypstatename) : that.ypstatename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ypstatename != null ? ypstatename.hashCode() : 0);
        return result;
    }
}
