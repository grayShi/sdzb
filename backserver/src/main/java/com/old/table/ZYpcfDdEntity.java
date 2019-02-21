package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZYpcfDD", schema = "dbo", catalog = "shaoxiongtest")
public class ZYpcfDdEntity {
    private int id;
    private String cfdd;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Cfdd", nullable = true, length = 50)
    public String getCfdd() {
        return cfdd;
    }

    public void setCfdd(String cfdd) {
        this.cfdd = cfdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZYpcfDdEntity that = (ZYpcfDdEntity) o;

        if (id != that.id) return false;
        if (cfdd != null ? !cfdd.equals(that.cfdd) : that.cfdd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cfdd != null ? cfdd.hashCode() : 0);
        return result;
    }
}
