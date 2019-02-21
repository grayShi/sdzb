package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZUserXljl", schema = "dbo", catalog = "shaoxiongtest")
public class ZUserXljlEntity {
    private int id;
    private Integer userid;
    private Timestamp rudate;
    private Timestamp bydate;
    private String professional;
    private String graduateSchool;
    private String degreeXw;
    private String degreeXl;

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
    @Column(name = "rudate", nullable = true)
    public Timestamp getRudate() {
        return rudate;
    }

    public void setRudate(Timestamp rudate) {
        this.rudate = rudate;
    }

    @Basic
    @Column(name = "bydate", nullable = true)
    public Timestamp getBydate() {
        return bydate;
    }

    public void setBydate(Timestamp bydate) {
        this.bydate = bydate;
    }

    @Basic
    @Column(name = "professional", nullable = true, length = 50)
    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    @Basic
    @Column(name = "GraduateSchool", nullable = true, length = 50)
    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    @Basic
    @Column(name = "DegreeXw", nullable = true, length = 50)
    public String getDegreeXw() {
        return degreeXw;
    }

    public void setDegreeXw(String degreeXw) {
        this.degreeXw = degreeXw;
    }

    @Basic
    @Column(name = "DegreeXl", nullable = true, length = 50)
    public String getDegreeXl() {
        return degreeXl;
    }

    public void setDegreeXl(String degreeXl) {
        this.degreeXl = degreeXl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZUserXljlEntity that = (ZUserXljlEntity) o;

        if (id != that.id) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (rudate != null ? !rudate.equals(that.rudate) : that.rudate != null) return false;
        if (bydate != null ? !bydate.equals(that.bydate) : that.bydate != null) return false;
        if (professional != null ? !professional.equals(that.professional) : that.professional != null) return false;
        if (graduateSchool != null ? !graduateSchool.equals(that.graduateSchool) : that.graduateSchool != null) return false;
        if (degreeXw != null ? !degreeXw.equals(that.degreeXw) : that.degreeXw != null) return false;
        if (degreeXl != null ? !degreeXl.equals(that.degreeXl) : that.degreeXl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (rudate != null ? rudate.hashCode() : 0);
        result = 31 * result + (bydate != null ? bydate.hashCode() : 0);
        result = 31 * result + (professional != null ? professional.hashCode() : 0);
        result = 31 * result + (graduateSchool != null ? graduateSchool.hashCode() : 0);
        result = 31 * result + (degreeXw != null ? degreeXw.hashCode() : 0);
        result = 31 * result + (degreeXl != null ? degreeXl.hashCode() : 0);
        return result;
    }
}
