package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZZylb", schema = "dbo", catalog = "shaoxiongtest")
public class ZZylbEntity {
    private int id;
    private String zylbname;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "zylbname", nullable = true, length = 50)
    public String getZylbname() {
        return zylbname;
    }

    public void setZylbname(String zylbname) {
        this.zylbname = zylbname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZZylbEntity that = (ZZylbEntity) o;

        if (id != that.id) return false;
        if (zylbname != null ? !zylbname.equals(that.zylbname) : that.zylbname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (zylbname != null ? zylbname.hashCode() : 0);
        return result;
    }
}
