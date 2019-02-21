package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZUserZcjl", schema = "dbo", catalog = "shaoxiongtest")
public class ZUserZcjlEntity {
    private int id;
    private Integer userid;
    private String eTitles;
    private String eProfessional;
    private Timestamp erzdate;
    private String esqdept;
    private String ebz;

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
    @Column(name = "ETitles", nullable = true, length = 50)
    public String geteTitles() {
        return eTitles;
    }

    public void seteTitles(String eTitles) {
        this.eTitles = eTitles;
    }

    @Basic
    @Column(name = "EProfessional", nullable = false, length = 50)
    public String geteProfessional() {
        return eProfessional;
    }

    public void seteProfessional(String eProfessional) {
        this.eProfessional = eProfessional;
    }

    @Basic
    @Column(name = "Erzdate", nullable = true)
    public Timestamp getErzdate() {
        return erzdate;
    }

    public void setErzdate(Timestamp erzdate) {
        this.erzdate = erzdate;
    }

    @Basic
    @Column(name = "Esqdept", nullable = true, length = 50)
    public String getEsqdept() {
        return esqdept;
    }

    public void setEsqdept(String esqdept) {
        this.esqdept = esqdept;
    }

    @Basic
    @Column(name = "Ebz", nullable = true, length = 50)
    public String getEbz() {
        return ebz;
    }

    public void setEbz(String ebz) {
        this.ebz = ebz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZUserZcjlEntity that = (ZUserZcjlEntity) o;

        if (id != that.id) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (eTitles != null ? !eTitles.equals(that.eTitles) : that.eTitles != null) return false;
        if (eProfessional != null ? !eProfessional.equals(that.eProfessional) : that.eProfessional != null) return false;
        if (erzdate != null ? !erzdate.equals(that.erzdate) : that.erzdate != null) return false;
        if (esqdept != null ? !esqdept.equals(that.esqdept) : that.esqdept != null) return false;
        if (ebz != null ? !ebz.equals(that.ebz) : that.ebz != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (eTitles != null ? eTitles.hashCode() : 0);
        result = 31 * result + (eProfessional != null ? eProfessional.hashCode() : 0);
        result = 31 * result + (erzdate != null ? erzdate.hashCode() : 0);
        result = 31 * result + (esqdept != null ? esqdept.hashCode() : 0);
        result = 31 * result + (ebz != null ? ebz.hashCode() : 0);
        return result;
    }
}
