package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZfgyyMsg", schema = "dbo", catalog = "shaoxiongtest")
public class ZfgyyMsgEntity {
    private int id;
    private String fgyyname;
    private String fgyyzs;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fgyyname", nullable = true, length = 2147483647)
    public String getFgyyname() {
        return fgyyname;
    }

    public void setFgyyname(String fgyyname) {
        this.fgyyname = fgyyname;
    }

    @Basic
    @Column(name = "fgyyzs", nullable = true, length = 2147483647)
    public String getFgyyzs() {
        return fgyyzs;
    }

    public void setFgyyzs(String fgyyzs) {
        this.fgyyzs = fgyyzs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZfgyyMsgEntity that = (ZfgyyMsgEntity) o;

        if (id != that.id) return false;
        if (fgyyname != null ? !fgyyname.equals(that.fgyyname) : that.fgyyname != null) return false;
        if (fgyyzs != null ? !fgyyzs.equals(that.fgyyzs) : that.fgyyzs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fgyyname != null ? fgyyname.hashCode() : 0);
        result = 31 * result + (fgyyzs != null ? fgyyzs.hashCode() : 0);
        return result;
    }
}
