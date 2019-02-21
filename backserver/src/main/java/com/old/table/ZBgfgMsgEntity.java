package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZBgfgMsg", schema = "dbo", catalog = "shaoxiongtest")
public class ZBgfgMsgEntity {
    private int id;
    private Integer ypid;
    private Integer bmid;
    private Integer bfgrname;
    private Integer fgrname;
    private Timestamp fgdate;
    private String fgyy;
    private String smmsg;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Ypid", nullable = true)
    public Integer getYpid() {
        return ypid;
    }

    public void setYpid(Integer ypid) {
        this.ypid = ypid;
    }

    @Basic
    @Column(name = "bmid", nullable = true)
    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }

    @Basic
    @Column(name = "bfgrname", nullable = true)
    public Integer getBfgrname() {
        return bfgrname;
    }

    public void setBfgrname(Integer bfgrname) {
        this.bfgrname = bfgrname;
    }

    @Basic
    @Column(name = "fgrname", nullable = true)
    public Integer getFgrname() {
        return fgrname;
    }

    public void setFgrname(Integer fgrname) {
        this.fgrname = fgrname;
    }

    @Basic
    @Column(name = "fgdate", nullable = true)
    public Timestamp getFgdate() {
        return fgdate;
    }

    public void setFgdate(Timestamp fgdate) {
        this.fgdate = fgdate;
    }

    @Basic
    @Column(name = "fgyy", nullable = true, length = 2147483647)
    public String getFgyy() {
        return fgyy;
    }

    public void setFgyy(String fgyy) {
        this.fgyy = fgyy;
    }

    @Basic
    @Column(name = "smmsg", nullable = true, length = 2147483647)
    public String getSmmsg() {
        return smmsg;
    }

    public void setSmmsg(String smmsg) {
        this.smmsg = smmsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZBgfgMsgEntity that = (ZBgfgMsgEntity) o;

        if (id != that.id) return false;
        if (ypid != null ? !ypid.equals(that.ypid) : that.ypid != null) return false;
        if (bmid != null ? !bmid.equals(that.bmid) : that.bmid != null) return false;
        if (bfgrname != null ? !bfgrname.equals(that.bfgrname) : that.bfgrname != null) return false;
        if (fgrname != null ? !fgrname.equals(that.fgrname) : that.fgrname != null) return false;
        if (fgdate != null ? !fgdate.equals(that.fgdate) : that.fgdate != null) return false;
        if (fgyy != null ? !fgyy.equals(that.fgyy) : that.fgyy != null) return false;
        if (smmsg != null ? !smmsg.equals(that.smmsg) : that.smmsg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ypid != null ? ypid.hashCode() : 0);
        result = 31 * result + (bmid != null ? bmid.hashCode() : 0);
        result = 31 * result + (bfgrname != null ? bfgrname.hashCode() : 0);
        result = 31 * result + (fgrname != null ? fgrname.hashCode() : 0);
        result = 31 * result + (fgdate != null ? fgdate.hashCode() : 0);
        result = 31 * result + (fgyy != null ? fgyy.hashCode() : 0);
        result = 31 * result + (smmsg != null ? smmsg.hashCode() : 0);
        return result;
    }
}
