package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZYpcyfs", schema = "dbo", catalog = "shaoxiongtest")
public class ZYpcyfsEntity {
    private int id;
    private String cyname;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cyname", nullable = true, length = 50)
    public String getCyname() {
        return cyname;
    }

    public void setCyname(String cyname) {
        this.cyname = cyname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZYpcyfsEntity that = (ZYpcyfsEntity) o;

        if (id != that.id) return false;
        if (cyname != null ? !cyname.equals(that.cyname) : that.cyname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cyname != null ? cyname.hashCode() : 0);
        return result;
    }
}
