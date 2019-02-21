package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZUser", schema = "dbo", catalog = "shaoxiongtest")
public class ZUserEntity {
    private int id;
    private String loginname;
    private String password;
    private String realname;
    private Integer deptid;
    private String qmurl;
    private Integer sex;
    private Timestamp birthday;
    private String ethnic;
    private Integer degree;
    private String zzmm;
    private String homeTown;
    private String gdphone;
    private String telephone;
    private String iDnumber;
    private String graduated;
    private String prefessional;
    private Timestamp grdudatedDate;
    private Timestamp enterDate;
    private String titles;
    private Timestamp officeDate;
    private String zpurl;
    private String qxbm;
    private Integer ismanger;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "loginname", nullable = true, length = 50)
    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "realname", nullable = true, length = 50)
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Basic
    @Column(name = "deptid", nullable = true)
    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    @Basic
    @Column(name = "qmurl", nullable = true, length = 50)
    public String getQmurl() {
        return qmurl;
    }

    public void setQmurl(String qmurl) {
        this.qmurl = qmurl;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "Ethnic", nullable = true, length = 50)
    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    @Basic
    @Column(name = "Degree", nullable = true)
    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    @Basic
    @Column(name = "Zzmm", nullable = true, length = 50)
    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }

    @Basic
    @Column(name = "HomeTown", nullable = true, length = 50)
    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Basic
    @Column(name = "gdphone", nullable = true, length = 50)
    public String getGdphone() {
        return gdphone;
    }

    public void setGdphone(String gdphone) {
        this.gdphone = gdphone;
    }

    @Basic
    @Column(name = "telephone", nullable = true, length = 50)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "IDnumber", nullable = true, length = 50)
    public String getiDnumber() {
        return iDnumber;
    }

    public void setiDnumber(String iDnumber) {
        this.iDnumber = iDnumber;
    }

    @Basic
    @Column(name = "Graduated", nullable = true, length = 50)
    public String getGraduated() {
        return graduated;
    }

    public void setGraduated(String graduated) {
        this.graduated = graduated;
    }

    @Basic
    @Column(name = "Prefessional", nullable = true, length = 50)
    public String getPrefessional() {
        return prefessional;
    }

    public void setPrefessional(String prefessional) {
        this.prefessional = prefessional;
    }

    @Basic
    @Column(name = "GrdudatedDate", nullable = true)
    public Timestamp getGrdudatedDate() {
        return grdudatedDate;
    }

    public void setGrdudatedDate(Timestamp grdudatedDate) {
        this.grdudatedDate = grdudatedDate;
    }

    @Basic
    @Column(name = "EnterDate", nullable = true)
    public Timestamp getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Timestamp enterDate) {
        this.enterDate = enterDate;
    }

    @Basic
    @Column(name = "Titles", nullable = true, length = 50)
    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    @Basic
    @Column(name = "OfficeDate", nullable = true)
    public Timestamp getOfficeDate() {
        return officeDate;
    }

    public void setOfficeDate(Timestamp officeDate) {
        this.officeDate = officeDate;
    }

    @Basic
    @Column(name = "Zpurl", nullable = true, length = 50)
    public String getZpurl() {
        return zpurl;
    }

    public void setZpurl(String zpurl) {
        this.zpurl = zpurl;
    }

    @Basic
    @Column(name = "qxbm", nullable = true, length = 200)
    public String getQxbm() {
        return qxbm;
    }

    public void setQxbm(String qxbm) {
        this.qxbm = qxbm;
    }

    @Basic
    @Column(name = "ismanger", nullable = true)
    public Integer getIsmanger() {
        return ismanger;
    }

    public void setIsmanger(Integer ismanger) {
        this.ismanger = ismanger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZUserEntity that = (ZUserEntity) o;

        if (id != that.id) return false;
        if (loginname != null ? !loginname.equals(that.loginname) : that.loginname != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (realname != null ? !realname.equals(that.realname) : that.realname != null) return false;
        if (deptid != null ? !deptid.equals(that.deptid) : that.deptid != null) return false;
        if (qmurl != null ? !qmurl.equals(that.qmurl) : that.qmurl != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (ethnic != null ? !ethnic.equals(that.ethnic) : that.ethnic != null) return false;
        if (degree != null ? !degree.equals(that.degree) : that.degree != null) return false;
        if (zzmm != null ? !zzmm.equals(that.zzmm) : that.zzmm != null) return false;
        if (homeTown != null ? !homeTown.equals(that.homeTown) : that.homeTown != null) return false;
        if (gdphone != null ? !gdphone.equals(that.gdphone) : that.gdphone != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (iDnumber != null ? !iDnumber.equals(that.iDnumber) : that.iDnumber != null) return false;
        if (graduated != null ? !graduated.equals(that.graduated) : that.graduated != null) return false;
        if (prefessional != null ? !prefessional.equals(that.prefessional) : that.prefessional != null) return false;
        if (grdudatedDate != null ? !grdudatedDate.equals(that.grdudatedDate) : that.grdudatedDate != null) return false;
        if (enterDate != null ? !enterDate.equals(that.enterDate) : that.enterDate != null) return false;
        if (titles != null ? !titles.equals(that.titles) : that.titles != null) return false;
        if (officeDate != null ? !officeDate.equals(that.officeDate) : that.officeDate != null) return false;
        if (zpurl != null ? !zpurl.equals(that.zpurl) : that.zpurl != null) return false;
        if (qxbm != null ? !qxbm.equals(that.qxbm) : that.qxbm != null) return false;
        if (ismanger != null ? !ismanger.equals(that.ismanger) : that.ismanger != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (loginname != null ? loginname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (realname != null ? realname.hashCode() : 0);
        result = 31 * result + (deptid != null ? deptid.hashCode() : 0);
        result = 31 * result + (qmurl != null ? qmurl.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (ethnic != null ? ethnic.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (zzmm != null ? zzmm.hashCode() : 0);
        result = 31 * result + (homeTown != null ? homeTown.hashCode() : 0);
        result = 31 * result + (gdphone != null ? gdphone.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (iDnumber != null ? iDnumber.hashCode() : 0);
        result = 31 * result + (graduated != null ? graduated.hashCode() : 0);
        result = 31 * result + (prefessional != null ? prefessional.hashCode() : 0);
        result = 31 * result + (grdudatedDate != null ? grdudatedDate.hashCode() : 0);
        result = 31 * result + (enterDate != null ? enterDate.hashCode() : 0);
        result = 31 * result + (titles != null ? titles.hashCode() : 0);
        result = 31 * result + (officeDate != null ? officeDate.hashCode() : 0);
        result = 31 * result + (zpurl != null ? zpurl.hashCode() : 0);
        result = 31 * result + (qxbm != null ? qxbm.hashCode() : 0);
        result = 31 * result + (ismanger != null ? ismanger.hashCode() : 0);
        return result;
    }
}
