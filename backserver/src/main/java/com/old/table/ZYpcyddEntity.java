package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZYpcydd", schema = "dbo", catalog = "shaoxiongtest")
public class ZYpcyddEntity {
    private int id;
    private String ypcydd;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ypcydd", nullable = true, length = 50)
    public String getYpcydd() {
        return ypcydd;
    }

    public void setYpcydd(String ypcydd) {
        this.ypcydd = ypcydd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZYpcyddEntity that = (ZYpcyddEntity) o;

        if (id != that.id) return false;
        if (ypcydd != null ? !ypcydd.equals(that.ypcydd) : that.ypcydd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ypcydd != null ? ypcydd.hashCode() : 0);
        return result;
    }
}
