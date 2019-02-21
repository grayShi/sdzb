package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZBgwcrq", schema = "dbo", catalog = "shaoxiongtest")
public class ZBgwcrqEntity {
    private int id;
    private String ypmc;
    private Integer wcts;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ypmc", nullable = true, length = 50)
    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    @Basic
    @Column(name = "wcts", nullable = true)
    public Integer getWcts() {
        return wcts;
    }

    public void setWcts(Integer wcts) {
        this.wcts = wcts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZBgwcrqEntity that = (ZBgwcrqEntity) o;

        if (id != that.id) return false;
        if (ypmc != null ? !ypmc.equals(that.ypmc) : that.ypmc != null) return false;
        if (wcts != null ? !wcts.equals(that.wcts) : that.wcts != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ypmc != null ? ypmc.hashCode() : 0);
        result = 31 * result + (wcts != null ? wcts.hashCode() : 0);
        return result;
    }
}
