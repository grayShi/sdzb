package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Zjylx", schema = "dbo", catalog = "shaoxiongtest")
public class ZjylxEntity {
    private int id;
    private String lxmc;
    private String lxurl;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lxmc", nullable = true, length = 50)
    public String getLxmc() {
        return lxmc;
    }

    public void setLxmc(String lxmc) {
        this.lxmc = lxmc;
    }

    @Basic
    @Column(name = "lxurl", nullable = true, length = 50)
    public String getLxurl() {
        return lxurl;
    }

    public void setLxurl(String lxurl) {
        this.lxurl = lxurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZjylxEntity that = (ZjylxEntity) o;

        if (id != that.id) return false;
        if (lxmc != null ? !lxmc.equals(that.lxmc) : that.lxmc != null) return false;
        if (lxurl != null ? !lxurl.equals(that.lxurl) : that.lxurl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lxmc != null ? lxmc.hashCode() : 0);
        result = 31 * result + (lxurl != null ? lxurl.hashCode() : 0);
        return result;
    }
}
