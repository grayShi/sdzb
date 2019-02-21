package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CxxsszList", schema = "dbo", catalog = "shaoxiongtest")
public class CxxsszListEntity {
    private int id;
    private String cxName;
    private String ziduan;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CxName", nullable = true, length = 50)
    public String getCxName() {
        return cxName;
    }

    public void setCxName(String cxName) {
        this.cxName = cxName;
    }

    @Basic
    @Column(name = "ziduan", nullable = true, length = 500)
    public String getZiduan() {
        return ziduan;
    }

    public void setZiduan(String ziduan) {
        this.ziduan = ziduan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CxxsszListEntity that = (CxxsszListEntity) o;

        if (id != that.id) return false;
        if (cxName != null ? !cxName.equals(that.cxName) : that.cxName != null) return false;
        if (ziduan != null ? !ziduan.equals(that.ziduan) : that.ziduan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cxName != null ? cxName.hashCode() : 0);
        result = 31 * result + (ziduan != null ? ziduan.hashCode() : 0);
        return result;
    }
}
