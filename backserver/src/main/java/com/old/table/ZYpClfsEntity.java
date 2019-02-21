package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZYpClfs", schema = "dbo", catalog = "shaoxiongtest")
public class ZYpClfsEntity {
    private int id;
    private String ypclfsname;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Ypclfsname", nullable = true, length = 50)
    public String getYpclfsname() {
        return ypclfsname;
    }

    public void setYpclfsname(String ypclfsname) {
        this.ypclfsname = ypclfsname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZYpClfsEntity that = (ZYpClfsEntity) o;

        if (id != that.id) return false;
        if (ypclfsname != null ? !ypclfsname.equals(that.ypclfsname) : that.ypclfsname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ypclfsname != null ? ypclfsname.hashCode() : 0);
        return result;
    }
}
