package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZMkgl", schema = "dbo", catalog = "shaoxiongtest")
public class ZMkglEntity {
    private int id;
    private String mkname;
    private String mksrc;
    private String mkmb;
    private Integer supid;
    private Integer xuhao;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mkname", nullable = true, length = 50)
    public String getMkname() {
        return mkname;
    }

    public void setMkname(String mkname) {
        this.mkname = mkname;
    }

    @Basic
    @Column(name = "mksrc", nullable = true, length = 50)
    public String getMksrc() {
        return mksrc;
    }

    public void setMksrc(String mksrc) {
        this.mksrc = mksrc;
    }

    @Basic
    @Column(name = "mkmb", nullable = true, length = 50)
    public String getMkmb() {
        return mkmb;
    }

    public void setMkmb(String mkmb) {
        this.mkmb = mkmb;
    }

    @Basic
    @Column(name = "supid", nullable = true)
    public Integer getSupid() {
        return supid;
    }

    public void setSupid(Integer supid) {
        this.supid = supid;
    }

    @Basic
    @Column(name = "xuhao", nullable = true)
    public Integer getXuhao() {
        return xuhao;
    }

    public void setXuhao(Integer xuhao) {
        this.xuhao = xuhao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZMkglEntity that = (ZMkglEntity) o;

        if (id != that.id) return false;
        if (mkname != null ? !mkname.equals(that.mkname) : that.mkname != null) return false;
        if (mksrc != null ? !mksrc.equals(that.mksrc) : that.mksrc != null) return false;
        if (mkmb != null ? !mkmb.equals(that.mkmb) : that.mkmb != null) return false;
        if (supid != null ? !supid.equals(that.supid) : that.supid != null) return false;
        if (xuhao != null ? !xuhao.equals(that.xuhao) : that.xuhao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mkname != null ? mkname.hashCode() : 0);
        result = 31 * result + (mksrc != null ? mksrc.hashCode() : 0);
        result = 31 * result + (mkmb != null ? mkmb.hashCode() : 0);
        result = 31 * result + (supid != null ? supid.hashCode() : 0);
        result = 31 * result + (xuhao != null ? xuhao.hashCode() : 0);
        return result;
    }
}
