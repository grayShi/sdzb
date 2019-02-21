package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZSffs", schema = "dbo", catalog = "shaoxiongtest")
public class ZSffsEntity {
    private int id;
    private String sffs;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sffs", nullable = true, length = 50)
    public String getSffs() {
        return sffs;
    }

    public void setSffs(String sffs) {
        this.sffs = sffs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZSffsEntity that = (ZSffsEntity) o;

        if (id != that.id) return false;
        if (sffs != null ? !sffs.equals(that.sffs) : that.sffs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sffs != null ? sffs.hashCode() : 0);
        return result;
    }
}
