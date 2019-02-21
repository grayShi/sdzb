package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZUserGzjl", schema = "dbo", catalog = "shaoxiongtest")
public class ZUserGzjlEntity {
    private int id;
    private Integer userid;
    private Timestamp gqsdate;
    private String gGzdw;
    private String gDept;
    private String gzWu;
    private String gGznr;

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
    @Column(name = "Gqsdate", nullable = true)
    public Timestamp getGqsdate() {
        return gqsdate;
    }

    public void setGqsdate(Timestamp gqsdate) {
        this.gqsdate = gqsdate;
    }

    @Basic
    @Column(name = "GGzdw", nullable = true, length = 50)
    public String getgGzdw() {
        return gGzdw;
    }

    public void setgGzdw(String gGzdw) {
        this.gGzdw = gGzdw;
    }

    @Basic
    @Column(name = "GDept", nullable = true, length = 50)
    public String getgDept() {
        return gDept;
    }

    public void setgDept(String gDept) {
        this.gDept = gDept;
    }

    @Basic
    @Column(name = "GZWu", nullable = true, length = 50)
    public String getGzWu() {
        return gzWu;
    }

    public void setGzWu(String gzWu) {
        this.gzWu = gzWu;
    }

    @Basic
    @Column(name = "GGznr", nullable = true, length = 2147483647)
    public String getgGznr() {
        return gGznr;
    }

    public void setgGznr(String gGznr) {
        this.gGznr = gGznr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZUserGzjlEntity that = (ZUserGzjlEntity) o;

        if (id != that.id) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (gqsdate != null ? !gqsdate.equals(that.gqsdate) : that.gqsdate != null) return false;
        if (gGzdw != null ? !gGzdw.equals(that.gGzdw) : that.gGzdw != null) return false;
        if (gDept != null ? !gDept.equals(that.gDept) : that.gDept != null) return false;
        if (gzWu != null ? !gzWu.equals(that.gzWu) : that.gzWu != null) return false;
        if (gGznr != null ? !gGznr.equals(that.gGznr) : that.gGznr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (gqsdate != null ? gqsdate.hashCode() : 0);
        result = 31 * result + (gGzdw != null ? gGzdw.hashCode() : 0);
        result = 31 * result + (gDept != null ? gDept.hashCode() : 0);
        result = 31 * result + (gzWu != null ? gzWu.hashCode() : 0);
        result = 31 * result + (gGznr != null ? gGznr.hashCode() : 0);
        return result;
    }
}
