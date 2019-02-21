package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZTsfh", schema = "dbo", catalog = "shaoxiongtest")
public class ZTsfhEntity {
    private int id;
    private String fh;
    private String fhname;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fh", nullable = true, length = 50)
    public String getFh() {
        return fh;
    }

    public void setFh(String fh) {
        this.fh = fh;
    }

    @Basic
    @Column(name = "fhname", nullable = true, length = 50)
    public String getFhname() {
        return fhname;
    }

    public void setFhname(String fhname) {
        this.fhname = fhname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZTsfhEntity that = (ZTsfhEntity) o;

        if (id != that.id) return false;
        if (fh != null ? !fh.equals(that.fh) : that.fh != null) return false;
        if (fhname != null ? !fhname.equals(that.fhname) : that.fhname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fh != null ? fh.hashCode() : 0);
        result = 31 * result + (fhname != null ? fhname.hashCode() : 0);
        return result;
    }
}
