package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "YpbhList", schema = "dbo", catalog = "shaoxiongtest")
public class YpbhListEntity {
    private int id;
    private String ypname;
    private String ypbh;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Ypname", nullable = true, length = 50)
    public String getYpname() {
        return ypname;
    }

    public void setYpname(String ypname) {
        this.ypname = ypname;
    }

    @Basic
    @Column(name = "Ypbh", nullable = true, length = 20)
    public String getYpbh() {
        return ypbh;
    }

    public void setYpbh(String ypbh) {
        this.ypbh = ypbh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YpbhListEntity that = (YpbhListEntity) o;

        if (id != that.id) return false;
        if (ypname != null ? !ypname.equals(that.ypname) : that.ypname != null) return false;
        if (ypbh != null ? !ypbh.equals(that.ypbh) : that.ypbh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ypname != null ? ypname.hashCode() : 0);
        result = 31 * result + (ypbh != null ? ypbh.hashCode() : 0);
        return result;
    }
}
