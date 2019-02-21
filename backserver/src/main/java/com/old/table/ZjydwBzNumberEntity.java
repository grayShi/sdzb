package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZjydwBzNumber", schema = "dbo", catalog = "shaoxiongtest")
public class ZjydwBzNumberEntity {
    private int id;
    private Integer jydwid;
    private Integer bzid;
    private String bznumber;
    private Timestamp dateqi;
    private Timestamp datezhi;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "jydwid", nullable = true)
    public Integer getJydwid() {
        return jydwid;
    }

    public void setJydwid(Integer jydwid) {
        this.jydwid = jydwid;
    }

    @Basic
    @Column(name = "bzid", nullable = true)
    public Integer getBzid() {
        return bzid;
    }

    public void setBzid(Integer bzid) {
        this.bzid = bzid;
    }

    @Basic
    @Column(name = "bznumber", nullable = true, length = 50)
    public String getBznumber() {
        return bznumber;
    }

    public void setBznumber(String bznumber) {
        this.bznumber = bznumber;
    }

    @Basic
    @Column(name = "Dateqi", nullable = true)
    public Timestamp getDateqi() {
        return dateqi;
    }

    public void setDateqi(Timestamp dateqi) {
        this.dateqi = dateqi;
    }

    @Basic
    @Column(name = "Datezhi", nullable = true)
    public Timestamp getDatezhi() {
        return datezhi;
    }

    public void setDatezhi(Timestamp datezhi) {
        this.datezhi = datezhi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZjydwBzNumberEntity that = (ZjydwBzNumberEntity) o;

        if (id != that.id) return false;
        if (jydwid != null ? !jydwid.equals(that.jydwid) : that.jydwid != null) return false;
        if (bzid != null ? !bzid.equals(that.bzid) : that.bzid != null) return false;
        if (bznumber != null ? !bznumber.equals(that.bznumber) : that.bznumber != null) return false;
        if (dateqi != null ? !dateqi.equals(that.dateqi) : that.dateqi != null) return false;
        if (datezhi != null ? !datezhi.equals(that.datezhi) : that.datezhi != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (jydwid != null ? jydwid.hashCode() : 0);
        result = 31 * result + (bzid != null ? bzid.hashCode() : 0);
        result = 31 * result + (bznumber != null ? bznumber.hashCode() : 0);
        result = 31 * result + (dateqi != null ? dateqi.hashCode() : 0);
        result = 31 * result + (datezhi != null ? datezhi.hashCode() : 0);
        return result;
    }
}
