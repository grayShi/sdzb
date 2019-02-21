package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZGgglmsg", schema = "dbo", catalog = "shaoxiongtest")
public class ZGgglmsgEntity {
    private int id;
    private String ggtitle;
    private String ggContent;
    private Integer ggFbr;
    private Timestamp ggFbdate;
    private Integer isOk;
    private String lxurl;
    private String lxname;
    private String lxurl1;
    private String lxname1;
    private String lxurl2;
    private String lxname2;
    private String lxurl3;
    private String lxname3;
    private String lxurl4;
    private String lxname4;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Ggtitle", nullable = true, length = 50)
    public String getGgtitle() {
        return ggtitle;
    }

    public void setGgtitle(String ggtitle) {
        this.ggtitle = ggtitle;
    }

    @Basic
    @Column(name = "GgContent", nullable = true, length = 2147483647)
    public String getGgContent() {
        return ggContent;
    }

    public void setGgContent(String ggContent) {
        this.ggContent = ggContent;
    }

    @Basic
    @Column(name = "GgFbr", nullable = true)
    public Integer getGgFbr() {
        return ggFbr;
    }

    public void setGgFbr(Integer ggFbr) {
        this.ggFbr = ggFbr;
    }

    @Basic
    @Column(name = "GgFbdate", nullable = true)
    public Timestamp getGgFbdate() {
        return ggFbdate;
    }

    public void setGgFbdate(Timestamp ggFbdate) {
        this.ggFbdate = ggFbdate;
    }

    @Basic
    @Column(name = "isOk", nullable = true)
    public Integer getIsOk() {
        return isOk;
    }

    public void setIsOk(Integer isOk) {
        this.isOk = isOk;
    }

    @Basic
    @Column(name = "lxurl", nullable = true, length = 50)
    public String getLxurl() {
        return lxurl;
    }

    public void setLxurl(String lxurl) {
        this.lxurl = lxurl;
    }

    @Basic
    @Column(name = "lxname", nullable = true, length = 50)
    public String getLxname() {
        return lxname;
    }

    public void setLxname(String lxname) {
        this.lxname = lxname;
    }

    @Basic
    @Column(name = "lxurl1", nullable = true, length = 50)
    public String getLxurl1() {
        return lxurl1;
    }

    public void setLxurl1(String lxurl1) {
        this.lxurl1 = lxurl1;
    }

    @Basic
    @Column(name = "lxname1", nullable = true, length = 50)
    public String getLxname1() {
        return lxname1;
    }

    public void setLxname1(String lxname1) {
        this.lxname1 = lxname1;
    }

    @Basic
    @Column(name = "lxurl2", nullable = true, length = 50)
    public String getLxurl2() {
        return lxurl2;
    }

    public void setLxurl2(String lxurl2) {
        this.lxurl2 = lxurl2;
    }

    @Basic
    @Column(name = "lxname2", nullable = true, length = 50)
    public String getLxname2() {
        return lxname2;
    }

    public void setLxname2(String lxname2) {
        this.lxname2 = lxname2;
    }

    @Basic
    @Column(name = "lxurl3", nullable = true, length = 50)
    public String getLxurl3() {
        return lxurl3;
    }

    public void setLxurl3(String lxurl3) {
        this.lxurl3 = lxurl3;
    }

    @Basic
    @Column(name = "lxname3", nullable = true, length = 50)
    public String getLxname3() {
        return lxname3;
    }

    public void setLxname3(String lxname3) {
        this.lxname3 = lxname3;
    }

    @Basic
    @Column(name = "lxurl4", nullable = true, length = 50)
    public String getLxurl4() {
        return lxurl4;
    }

    public void setLxurl4(String lxurl4) {
        this.lxurl4 = lxurl4;
    }

    @Basic
    @Column(name = "lxname4", nullable = true, length = 50)
    public String getLxname4() {
        return lxname4;
    }

    public void setLxname4(String lxname4) {
        this.lxname4 = lxname4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZGgglmsgEntity that = (ZGgglmsgEntity) o;

        if (id != that.id) return false;
        if (ggtitle != null ? !ggtitle.equals(that.ggtitle) : that.ggtitle != null) return false;
        if (ggContent != null ? !ggContent.equals(that.ggContent) : that.ggContent != null) return false;
        if (ggFbr != null ? !ggFbr.equals(that.ggFbr) : that.ggFbr != null) return false;
        if (ggFbdate != null ? !ggFbdate.equals(that.ggFbdate) : that.ggFbdate != null) return false;
        if (isOk != null ? !isOk.equals(that.isOk) : that.isOk != null) return false;
        if (lxurl != null ? !lxurl.equals(that.lxurl) : that.lxurl != null) return false;
        if (lxname != null ? !lxname.equals(that.lxname) : that.lxname != null) return false;
        if (lxurl1 != null ? !lxurl1.equals(that.lxurl1) : that.lxurl1 != null) return false;
        if (lxname1 != null ? !lxname1.equals(that.lxname1) : that.lxname1 != null) return false;
        if (lxurl2 != null ? !lxurl2.equals(that.lxurl2) : that.lxurl2 != null) return false;
        if (lxname2 != null ? !lxname2.equals(that.lxname2) : that.lxname2 != null) return false;
        if (lxurl3 != null ? !lxurl3.equals(that.lxurl3) : that.lxurl3 != null) return false;
        if (lxname3 != null ? !lxname3.equals(that.lxname3) : that.lxname3 != null) return false;
        if (lxurl4 != null ? !lxurl4.equals(that.lxurl4) : that.lxurl4 != null) return false;
        if (lxname4 != null ? !lxname4.equals(that.lxname4) : that.lxname4 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ggtitle != null ? ggtitle.hashCode() : 0);
        result = 31 * result + (ggContent != null ? ggContent.hashCode() : 0);
        result = 31 * result + (ggFbr != null ? ggFbr.hashCode() : 0);
        result = 31 * result + (ggFbdate != null ? ggFbdate.hashCode() : 0);
        result = 31 * result + (isOk != null ? isOk.hashCode() : 0);
        result = 31 * result + (lxurl != null ? lxurl.hashCode() : 0);
        result = 31 * result + (lxname != null ? lxname.hashCode() : 0);
        result = 31 * result + (lxurl1 != null ? lxurl1.hashCode() : 0);
        result = 31 * result + (lxname1 != null ? lxname1.hashCode() : 0);
        result = 31 * result + (lxurl2 != null ? lxurl2.hashCode() : 0);
        result = 31 * result + (lxname2 != null ? lxname2.hashCode() : 0);
        result = 31 * result + (lxurl3 != null ? lxurl3.hashCode() : 0);
        result = 31 * result + (lxname3 != null ? lxname3.hashCode() : 0);
        result = 31 * result + (lxurl4 != null ? lxurl4.hashCode() : 0);
        result = 31 * result + (lxname4 != null ? lxname4.hashCode() : 0);
        return result;
    }
}
