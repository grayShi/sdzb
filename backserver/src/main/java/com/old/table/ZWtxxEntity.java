package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZWtxx", schema = "dbo", catalog = "shaoxiongtest")
public class ZWtxxEntity {
    private int id;
    private String wtdwname;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wtdwname", nullable = true, length = 50)
    public String getWtdwname() {
        return wtdwname;
    }

    public void setWtdwname(String wtdwname) {
        this.wtdwname = wtdwname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZWtxxEntity that = (ZWtxxEntity) o;

        if (id != that.id) return false;
        if (wtdwname != null ? !wtdwname.equals(that.wtdwname) : that.wtdwname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (wtdwname != null ? wtdwname.hashCode() : 0);
        return result;
    }
}
