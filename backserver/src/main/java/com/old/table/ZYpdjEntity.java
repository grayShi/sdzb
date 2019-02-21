package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZYpdj", schema = "dbo", catalog = "shaoxiongtest")
public class ZYpdjEntity {
    private int id;
    private String djname;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Djname", nullable = true, length = 50)
    public String getDjname() {
        return djname;
    }

    public void setDjname(String djname) {
        this.djname = djname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZYpdjEntity that = (ZYpdjEntity) o;

        if (id != that.id) return false;
        if (djname != null ? !djname.equals(that.djname) : that.djname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (djname != null ? djname.hashCode() : 0);
        return result;
    }
}
