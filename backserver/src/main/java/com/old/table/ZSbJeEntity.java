package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "ZSbJe", schema = "dbo", catalog = "shaoxiongtest")
public class ZSbJeEntity {
    private int id;
    private Integer sbid;
    private String bh;
    private Timestamp jcrq;
    private Timestamp czrq;
    private BigDecimal je;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sbid", nullable = true)
    public Integer getSbid() {
        return sbid;
    }

    public void setSbid(Integer sbid) {
        this.sbid = sbid;
    }

    @Basic
    @Column(name = "bh", nullable = true, length = 50)
    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    @Basic
    @Column(name = "jcrq", nullable = true)
    public Timestamp getJcrq() {
        return jcrq;
    }

    public void setJcrq(Timestamp jcrq) {
        this.jcrq = jcrq;
    }

    @Basic
    @Column(name = "czrq", nullable = true)
    public Timestamp getCzrq() {
        return czrq;
    }

    public void setCzrq(Timestamp czrq) {
        this.czrq = czrq;
    }

    @Basic
    @Column(name = "je", nullable = true, precision = 2)
    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZSbJeEntity that = (ZSbJeEntity) o;

        if (id != that.id) return false;
        if (sbid != null ? !sbid.equals(that.sbid) : that.sbid != null) return false;
        if (bh != null ? !bh.equals(that.bh) : that.bh != null) return false;
        if (jcrq != null ? !jcrq.equals(that.jcrq) : that.jcrq != null) return false;
        if (czrq != null ? !czrq.equals(that.czrq) : that.czrq != null) return false;
        if (je != null ? !je.equals(that.je) : that.je != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sbid != null ? sbid.hashCode() : 0);
        result = 31 * result + (bh != null ? bh.hashCode() : 0);
        result = 31 * result + (jcrq != null ? jcrq.hashCode() : 0);
        result = 31 * result + (czrq != null ? czrq.hashCode() : 0);
        result = 31 * result + (je != null ? je.hashCode() : 0);
        return result;
    }
}
