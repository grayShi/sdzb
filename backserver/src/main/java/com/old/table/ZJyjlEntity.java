package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZJyjl", schema = "dbo", catalog = "shaoxiongtest")
public class ZJyjlEntity {
    private int id;
    private String jyjl;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "jyjl", nullable = true, length = 2147483647)
    public String getJyjl() {
        return jyjl;
    }

    public void setJyjl(String jyjl) {
        this.jyjl = jyjl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZJyjlEntity that = (ZJyjlEntity) o;

        if (id != that.id) return false;
        if (jyjl != null ? !jyjl.equals(that.jyjl) : that.jyjl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (jyjl != null ? jyjl.hashCode() : 0);
        return result;
    }
}
