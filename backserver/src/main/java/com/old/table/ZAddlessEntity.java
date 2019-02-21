package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZAddless", schema = "dbo", catalog = "shaoxiongtest")
public class ZAddlessEntity {
    private int id;
    private String dqName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DqName", nullable = true, length = 50)
    public String getDqName() {
        return dqName;
    }

    public void setDqName(String dqName) {
        this.dqName = dqName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZAddlessEntity that = (ZAddlessEntity) o;

        if (id != that.id) return false;
        if (dqName != null ? !dqName.equals(that.dqName) : that.dqName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dqName != null ? dqName.hashCode() : 0);
        return result;
    }
}
