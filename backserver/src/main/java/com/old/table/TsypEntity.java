package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tsyp", schema = "dbo", catalog = "shaoxiongtest")
public class TsypEntity {
    private int id;
    private String ypname;
    private String days;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Ypname", nullable = true, length = 50)
    public String getYpname() {
        return ypname;
    }

    public void setYpname(String ypname) {
        this.ypname = ypname;
    }

    @Basic
    @Column(name = "Days", nullable = true, length = 50)
    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TsypEntity that = (TsypEntity) o;

        if (id != that.id) return false;
        if (ypname != null ? !ypname.equals(that.ypname) : that.ypname != null) return false;
        if (days != null ? !days.equals(that.days) : that.days != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ypname != null ? ypname.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        return result;
    }
}
