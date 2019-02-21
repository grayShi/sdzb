package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZInfoBillScSc", schema = "dbo", catalog = "shaoxiongtest")
public class ZInfoBillScScEntity {
    private int id;
    private Integer infscid;
    private String jicxm;
    private String jsyq;
    private String dwname;
    private Integer sfhg;
    private String canshu1;
    private String canshu2;
    private String canshu3;
    private String canshu4;
    private String canshu5;
    private String canshu6;
    private String canshu7;
    private String canshu8;
    private String canshu9;
    private String canshu10;
    private String xuhaobh;
    private String xuhaopx;
    private Integer idlist;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "infscid", nullable = true)
    public Integer getInfscid() {
        return infscid;
    }

    public void setInfscid(Integer infscid) {
        this.infscid = infscid;
    }

    @Basic
    @Column(name = "jicxm", nullable = true, length = 2147483647)
    public String getJicxm() {
        return jicxm;
    }

    public void setJicxm(String jicxm) {
        this.jicxm = jicxm;
    }

    @Basic
    @Column(name = "jsyq", nullable = true, length = 2147483647)
    public String getJsyq() {
        return jsyq;
    }

    public void setJsyq(String jsyq) {
        this.jsyq = jsyq;
    }

    @Basic
    @Column(name = "dwname", nullable = true, length = 2147483647)
    public String getDwname() {
        return dwname;
    }

    public void setDwname(String dwname) {
        this.dwname = dwname;
    }

    @Basic
    @Column(name = "sfhg", nullable = true)
    public Integer getSfhg() {
        return sfhg;
    }

    public void setSfhg(Integer sfhg) {
        this.sfhg = sfhg;
    }

    @Basic
    @Column(name = "canshu1", nullable = true, length = 2147483647)
    public String getCanshu1() {
        return canshu1;
    }

    public void setCanshu1(String canshu1) {
        this.canshu1 = canshu1;
    }

    @Basic
    @Column(name = "canshu2", nullable = true, length = 2147483647)
    public String getCanshu2() {
        return canshu2;
    }

    public void setCanshu2(String canshu2) {
        this.canshu2 = canshu2;
    }

    @Basic
    @Column(name = "canshu3", nullable = true, length = 2147483647)
    public String getCanshu3() {
        return canshu3;
    }

    public void setCanshu3(String canshu3) {
        this.canshu3 = canshu3;
    }

    @Basic
    @Column(name = "canshu4", nullable = true, length = 2147483647)
    public String getCanshu4() {
        return canshu4;
    }

    public void setCanshu4(String canshu4) {
        this.canshu4 = canshu4;
    }

    @Basic
    @Column(name = "canshu5", nullable = true, length = 2147483647)
    public String getCanshu5() {
        return canshu5;
    }

    public void setCanshu5(String canshu5) {
        this.canshu5 = canshu5;
    }

    @Basic
    @Column(name = "canshu6", nullable = true, length = 2147483647)
    public String getCanshu6() {
        return canshu6;
    }

    public void setCanshu6(String canshu6) {
        this.canshu6 = canshu6;
    }

    @Basic
    @Column(name = "canshu7", nullable = true, length = 2147483647)
    public String getCanshu7() {
        return canshu7;
    }

    public void setCanshu7(String canshu7) {
        this.canshu7 = canshu7;
    }

    @Basic
    @Column(name = "canshu8", nullable = true, length = 2147483647)
    public String getCanshu8() {
        return canshu8;
    }

    public void setCanshu8(String canshu8) {
        this.canshu8 = canshu8;
    }

    @Basic
    @Column(name = "canshu9", nullable = true, length = 2147483647)
    public String getCanshu9() {
        return canshu9;
    }

    public void setCanshu9(String canshu9) {
        this.canshu9 = canshu9;
    }

    @Basic
    @Column(name = "canshu10", nullable = true, length = 2147483647)
    public String getCanshu10() {
        return canshu10;
    }

    public void setCanshu10(String canshu10) {
        this.canshu10 = canshu10;
    }

    @Basic
    @Column(name = "xuhaobh", nullable = true, length = 2147483647)
    public String getXuhaobh() {
        return xuhaobh;
    }

    public void setXuhaobh(String xuhaobh) {
        this.xuhaobh = xuhaobh;
    }

    @Basic
    @Column(name = "xuhaopx", nullable = true, length = 2147483647)
    public String getXuhaopx() {
        return xuhaopx;
    }

    public void setXuhaopx(String xuhaopx) {
        this.xuhaopx = xuhaopx;
    }

    @Basic
    @Column(name = "idlist", nullable = true)
    public Integer getIdlist() {
        return idlist;
    }

    public void setIdlist(Integer idlist) {
        this.idlist = idlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZInfoBillScScEntity that = (ZInfoBillScScEntity) o;

        if (id != that.id) return false;
        if (infscid != null ? !infscid.equals(that.infscid) : that.infscid != null) return false;
        if (jicxm != null ? !jicxm.equals(that.jicxm) : that.jicxm != null) return false;
        if (jsyq != null ? !jsyq.equals(that.jsyq) : that.jsyq != null) return false;
        if (dwname != null ? !dwname.equals(that.dwname) : that.dwname != null) return false;
        if (sfhg != null ? !sfhg.equals(that.sfhg) : that.sfhg != null) return false;
        if (canshu1 != null ? !canshu1.equals(that.canshu1) : that.canshu1 != null) return false;
        if (canshu2 != null ? !canshu2.equals(that.canshu2) : that.canshu2 != null) return false;
        if (canshu3 != null ? !canshu3.equals(that.canshu3) : that.canshu3 != null) return false;
        if (canshu4 != null ? !canshu4.equals(that.canshu4) : that.canshu4 != null) return false;
        if (canshu5 != null ? !canshu5.equals(that.canshu5) : that.canshu5 != null) return false;
        if (canshu6 != null ? !canshu6.equals(that.canshu6) : that.canshu6 != null) return false;
        if (canshu7 != null ? !canshu7.equals(that.canshu7) : that.canshu7 != null) return false;
        if (canshu8 != null ? !canshu8.equals(that.canshu8) : that.canshu8 != null) return false;
        if (canshu9 != null ? !canshu9.equals(that.canshu9) : that.canshu9 != null) return false;
        if (canshu10 != null ? !canshu10.equals(that.canshu10) : that.canshu10 != null) return false;
        if (xuhaobh != null ? !xuhaobh.equals(that.xuhaobh) : that.xuhaobh != null) return false;
        if (xuhaopx != null ? !xuhaopx.equals(that.xuhaopx) : that.xuhaopx != null) return false;
        if (idlist != null ? !idlist.equals(that.idlist) : that.idlist != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (infscid != null ? infscid.hashCode() : 0);
        result = 31 * result + (jicxm != null ? jicxm.hashCode() : 0);
        result = 31 * result + (jsyq != null ? jsyq.hashCode() : 0);
        result = 31 * result + (dwname != null ? dwname.hashCode() : 0);
        result = 31 * result + (sfhg != null ? sfhg.hashCode() : 0);
        result = 31 * result + (canshu1 != null ? canshu1.hashCode() : 0);
        result = 31 * result + (canshu2 != null ? canshu2.hashCode() : 0);
        result = 31 * result + (canshu3 != null ? canshu3.hashCode() : 0);
        result = 31 * result + (canshu4 != null ? canshu4.hashCode() : 0);
        result = 31 * result + (canshu5 != null ? canshu5.hashCode() : 0);
        result = 31 * result + (canshu6 != null ? canshu6.hashCode() : 0);
        result = 31 * result + (canshu7 != null ? canshu7.hashCode() : 0);
        result = 31 * result + (canshu8 != null ? canshu8.hashCode() : 0);
        result = 31 * result + (canshu9 != null ? canshu9.hashCode() : 0);
        result = 31 * result + (canshu10 != null ? canshu10.hashCode() : 0);
        result = 31 * result + (xuhaobh != null ? xuhaobh.hashCode() : 0);
        result = 31 * result + (xuhaopx != null ? xuhaopx.hashCode() : 0);
        result = 31 * result + (idlist != null ? idlist.hashCode() : 0);
        return result;
    }
}
