package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Zjydw", schema = "dbo", catalog = "shaoxiongtest")
public class ZjydwEntity {
    private int id;
    private String name;
    private String ename;
    private String bgidstyle;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ename", nullable = true, length = 2147483647)
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "bgidstyle", nullable = true, length = 50)
    public String getBgidstyle() {
        return bgidstyle;
    }

    public void setBgidstyle(String bgidstyle) {
        this.bgidstyle = bgidstyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZjydwEntity that = (ZjydwEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (ename != null ? !ename.equals(that.ename) : that.ename != null) return false;
        if (bgidstyle != null ? !bgidstyle.equals(that.bgidstyle) : that.bgidstyle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + (bgidstyle != null ? bgidstyle.hashCode() : 0);
        return result;
    }
}
