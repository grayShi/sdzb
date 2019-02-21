package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZCpJcxm", schema = "dbo", catalog = "shaoxiongtest")
public class ZCpJcxmEntity {
    private int id;
    private Integer cpJybzId;
    private String cpjcxmName;
    private String cpjcxmDw;
    private String cpjcxmJsyq;
    private String cpjcxmBz;
    private Integer cpjcxmDept;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CpJybzId", nullable = true)
    public Integer getCpJybzId() {
        return cpJybzId;
    }

    public void setCpJybzId(Integer cpJybzId) {
        this.cpJybzId = cpJybzId;
    }

    @Basic
    @Column(name = "CpjcxmName", nullable = true, length = 2147483647)
    public String getCpjcxmName() {
        return cpjcxmName;
    }

    public void setCpjcxmName(String cpjcxmName) {
        this.cpjcxmName = cpjcxmName;
    }

    @Basic
    @Column(name = "CpjcxmDw", nullable = true, length = 50)
    public String getCpjcxmDw() {
        return cpjcxmDw;
    }

    public void setCpjcxmDw(String cpjcxmDw) {
        this.cpjcxmDw = cpjcxmDw;
    }

    @Basic
    @Column(name = "CpjcxmJsyq", nullable = true, length = 2147483647)
    public String getCpjcxmJsyq() {
        return cpjcxmJsyq;
    }

    public void setCpjcxmJsyq(String cpjcxmJsyq) {
        this.cpjcxmJsyq = cpjcxmJsyq;
    }

    @Basic
    @Column(name = "CpjcxmBz", nullable = true, length = 2147483647)
    public String getCpjcxmBz() {
        return cpjcxmBz;
    }

    public void setCpjcxmBz(String cpjcxmBz) {
        this.cpjcxmBz = cpjcxmBz;
    }

    @Basic
    @Column(name = "CpjcxmDept", nullable = true)
    public Integer getCpjcxmDept() {
        return cpjcxmDept;
    }

    public void setCpjcxmDept(Integer cpjcxmDept) {
        this.cpjcxmDept = cpjcxmDept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZCpJcxmEntity that = (ZCpJcxmEntity) o;

        if (id != that.id) return false;
        if (cpJybzId != null ? !cpJybzId.equals(that.cpJybzId) : that.cpJybzId != null) return false;
        if (cpjcxmName != null ? !cpjcxmName.equals(that.cpjcxmName) : that.cpjcxmName != null) return false;
        if (cpjcxmDw != null ? !cpjcxmDw.equals(that.cpjcxmDw) : that.cpjcxmDw != null) return false;
        if (cpjcxmJsyq != null ? !cpjcxmJsyq.equals(that.cpjcxmJsyq) : that.cpjcxmJsyq != null) return false;
        if (cpjcxmBz != null ? !cpjcxmBz.equals(that.cpjcxmBz) : that.cpjcxmBz != null) return false;
        if (cpjcxmDept != null ? !cpjcxmDept.equals(that.cpjcxmDept) : that.cpjcxmDept != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cpJybzId != null ? cpJybzId.hashCode() : 0);
        result = 31 * result + (cpjcxmName != null ? cpjcxmName.hashCode() : 0);
        result = 31 * result + (cpjcxmDw != null ? cpjcxmDw.hashCode() : 0);
        result = 31 * result + (cpjcxmJsyq != null ? cpjcxmJsyq.hashCode() : 0);
        result = 31 * result + (cpjcxmBz != null ? cpjcxmBz.hashCode() : 0);
        result = 31 * result + (cpjcxmDept != null ? cpjcxmDept.hashCode() : 0);
        return result;
    }
}
