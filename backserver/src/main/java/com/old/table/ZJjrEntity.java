package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZJjr", schema = "dbo", catalog = "shaoxiongtest")
public class ZJjrEntity {
    private int id;
    private String jjr;
    private Timestamp ksdate;
    private Integer ts;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "jjr", nullable = true, length = 50)
    public String getJjr() {
        return jjr;
    }

    public void setJjr(String jjr) {
        this.jjr = jjr;
    }

    @Basic
    @Column(name = "ksdate", nullable = true)
    public Timestamp getKsdate() {
        return ksdate;
    }

    public void setKsdate(Timestamp ksdate) {
        this.ksdate = ksdate;
    }

    @Basic
    @Column(name = "ts", nullable = true)
    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZJjrEntity that = (ZJjrEntity) o;

        if (id != that.id) return false;
        if (jjr != null ? !jjr.equals(that.jjr) : that.jjr != null) return false;
        if (ksdate != null ? !ksdate.equals(that.ksdate) : that.ksdate != null) return false;
        if (ts != null ? !ts.equals(that.ts) : that.ts != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (jjr != null ? jjr.hashCode() : 0);
        result = 31 * result + (ksdate != null ? ksdate.hashCode() : 0);
        result = 31 * result + (ts != null ? ts.hashCode() : 0);
        return result;
    }
}
