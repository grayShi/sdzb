package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "jybzjcxm", schema = "dbo", catalog = "shaoxiongtest")
public class JybzjcxmEntity {
    private long id;
    private String jcxm;
    private String jcxmdw;
    private String jcxmjsyq;
    private String bz;
    private String cpbz;
    private String bm;

    @Basic
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "jcxm", nullable = true, length = 255)
    public String getJcxm() {
        return jcxm;
    }

    public void setJcxm(String jcxm) {
        this.jcxm = jcxm;
    }

    @Basic
    @Column(name = "jcxmdw", nullable = true, length = 50)
    public String getJcxmdw() {
        return jcxmdw;
    }

    public void setJcxmdw(String jcxmdw) {
        this.jcxmdw = jcxmdw;
    }

    @Basic
    @Column(name = "jcxmjsyq", nullable = true, length = 1024)
    public String getJcxmjsyq() {
        return jcxmjsyq;
    }

    public void setJcxmjsyq(String jcxmjsyq) {
        this.jcxmjsyq = jcxmjsyq;
    }

    @Basic
    @Column(name = "bz", nullable = true, length = 255)
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Basic
    @Column(name = "cpbz", nullable = true, length = 50)
    public String getCpbz() {
        return cpbz;
    }

    public void setCpbz(String cpbz) {
        this.cpbz = cpbz;
    }

    @Basic
    @Column(name = "bm", nullable = true, length = 50)
    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JybzjcxmEntity that = (JybzjcxmEntity) o;

        if (id != that.id) return false;
        if (jcxm != null ? !jcxm.equals(that.jcxm) : that.jcxm != null) return false;
        if (jcxmdw != null ? !jcxmdw.equals(that.jcxmdw) : that.jcxmdw != null) return false;
        if (jcxmjsyq != null ? !jcxmjsyq.equals(that.jcxmjsyq) : that.jcxmjsyq != null) return false;
        if (bz != null ? !bz.equals(that.bz) : that.bz != null) return false;
        if (cpbz != null ? !cpbz.equals(that.cpbz) : that.cpbz != null) return false;
        if (bm != null ? !bm.equals(that.bm) : that.bm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (jcxm != null ? jcxm.hashCode() : 0);
        result = 31 * result + (jcxmdw != null ? jcxmdw.hashCode() : 0);
        result = 31 * result + (jcxmjsyq != null ? jcxmjsyq.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        result = 31 * result + (cpbz != null ? cpbz.hashCode() : 0);
        result = 31 * result + (bm != null ? bm.hashCode() : 0);
        return result;
    }
}
