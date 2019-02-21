package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZWjgl", schema = "dbo", catalog = "shaoxiongtest")
public class ZWjglEntity {
    private int id;
    private String wjname;
    private String wjnumber;
    private Timestamp ssrq;
    private String zdbm;
    private Integer zylb;
    private String bz;
    private String wrurl;
    private Integer wjlb;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wjname", nullable = true, length = 50)
    public String getWjname() {
        return wjname;
    }

    public void setWjname(String wjname) {
        this.wjname = wjname;
    }

    @Basic
    @Column(name = "wjnumber", nullable = true, length = 50)
    public String getWjnumber() {
        return wjnumber;
    }

    public void setWjnumber(String wjnumber) {
        this.wjnumber = wjnumber;
    }

    @Basic
    @Column(name = "ssrq", nullable = true)
    public Timestamp getSsrq() {
        return ssrq;
    }

    public void setSsrq(Timestamp ssrq) {
        this.ssrq = ssrq;
    }

    @Basic
    @Column(name = "zdbm", nullable = true, length = 50)
    public String getZdbm() {
        return zdbm;
    }

    public void setZdbm(String zdbm) {
        this.zdbm = zdbm;
    }

    @Basic
    @Column(name = "zylb", nullable = true)
    public Integer getZylb() {
        return zylb;
    }

    public void setZylb(Integer zylb) {
        this.zylb = zylb;
    }

    @Basic
    @Column(name = "bz", nullable = true, length = 100)
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Basic
    @Column(name = "wrurl", nullable = true, length = 50)
    public String getWrurl() {
        return wrurl;
    }

    public void setWrurl(String wrurl) {
        this.wrurl = wrurl;
    }

    @Basic
    @Column(name = "wjlb", nullable = true)
    public Integer getWjlb() {
        return wjlb;
    }

    public void setWjlb(Integer wjlb) {
        this.wjlb = wjlb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZWjglEntity that = (ZWjglEntity) o;

        if (id != that.id) return false;
        if (wjname != null ? !wjname.equals(that.wjname) : that.wjname != null) return false;
        if (wjnumber != null ? !wjnumber.equals(that.wjnumber) : that.wjnumber != null) return false;
        if (ssrq != null ? !ssrq.equals(that.ssrq) : that.ssrq != null) return false;
        if (zdbm != null ? !zdbm.equals(that.zdbm) : that.zdbm != null) return false;
        if (zylb != null ? !zylb.equals(that.zylb) : that.zylb != null) return false;
        if (bz != null ? !bz.equals(that.bz) : that.bz != null) return false;
        if (wrurl != null ? !wrurl.equals(that.wrurl) : that.wrurl != null) return false;
        if (wjlb != null ? !wjlb.equals(that.wjlb) : that.wjlb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (wjname != null ? wjname.hashCode() : 0);
        result = 31 * result + (wjnumber != null ? wjnumber.hashCode() : 0);
        result = 31 * result + (ssrq != null ? ssrq.hashCode() : 0);
        result = 31 * result + (zdbm != null ? zdbm.hashCode() : 0);
        result = 31 * result + (zylb != null ? zylb.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        result = 31 * result + (wrurl != null ? wrurl.hashCode() : 0);
        result = 31 * result + (wjlb != null ? wjlb.hashCode() : 0);
        return result;
    }
}
