package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZUserPxjl", schema = "dbo", catalog = "shaoxiongtest")
public class ZUserPxjlEntity {
    private int id;
    private Integer userid;
    private String pxxdate;
    private String pPxnr;
    private String pPxdw;
    private String pPxxs;
    private String pxcj;
    private String pSyzs;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "Pxxdate", nullable = true, length = 50)
    public String getPxxdate() {
        return pxxdate;
    }

    public void setPxxdate(String pxxdate) {
        this.pxxdate = pxxdate;
    }

    @Basic
    @Column(name = "PPxnr", nullable = true, length = 2147483647)
    public String getpPxnr() {
        return pPxnr;
    }

    public void setpPxnr(String pPxnr) {
        this.pPxnr = pPxnr;
    }

    @Basic
    @Column(name = "PPxdw", nullable = true, length = 50)
    public String getpPxdw() {
        return pPxdw;
    }

    public void setpPxdw(String pPxdw) {
        this.pPxdw = pPxdw;
    }

    @Basic
    @Column(name = "PPxxs", nullable = true, length = 50)
    public String getpPxxs() {
        return pPxxs;
    }

    public void setpPxxs(String pPxxs) {
        this.pPxxs = pPxxs;
    }

    @Basic
    @Column(name = "Pxcj", nullable = true, length = 50)
    public String getPxcj() {
        return pxcj;
    }

    public void setPxcj(String pxcj) {
        this.pxcj = pxcj;
    }

    @Basic
    @Column(name = "PSyzs", nullable = true, length = 50)
    public String getpSyzs() {
        return pSyzs;
    }

    public void setpSyzs(String pSyzs) {
        this.pSyzs = pSyzs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZUserPxjlEntity that = (ZUserPxjlEntity) o;

        if (id != that.id) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (pxxdate != null ? !pxxdate.equals(that.pxxdate) : that.pxxdate != null) return false;
        if (pPxnr != null ? !pPxnr.equals(that.pPxnr) : that.pPxnr != null) return false;
        if (pPxdw != null ? !pPxdw.equals(that.pPxdw) : that.pPxdw != null) return false;
        if (pPxxs != null ? !pPxxs.equals(that.pPxxs) : that.pPxxs != null) return false;
        if (pxcj != null ? !pxcj.equals(that.pxcj) : that.pxcj != null) return false;
        if (pSyzs != null ? !pSyzs.equals(that.pSyzs) : that.pSyzs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (pxxdate != null ? pxxdate.hashCode() : 0);
        result = 31 * result + (pPxnr != null ? pPxnr.hashCode() : 0);
        result = 31 * result + (pPxdw != null ? pPxdw.hashCode() : 0);
        result = 31 * result + (pPxxs != null ? pPxxs.hashCode() : 0);
        result = 31 * result + (pxcj != null ? pxcj.hashCode() : 0);
        result = 31 * result + (pSyzs != null ? pSyzs.hashCode() : 0);
        return result;
    }
}
