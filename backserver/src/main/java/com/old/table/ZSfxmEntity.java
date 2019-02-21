package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZSfxm", schema = "dbo", catalog = "shaoxiongtest")
public class ZSfxmEntity {
    private int id;
    private String sfxm;
    private String fhao;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sfxm", nullable = true, length = 50)
    public String getSfxm() {
        return sfxm;
    }

    public void setSfxm(String sfxm) {
        this.sfxm = sfxm;
    }

    @Basic
    @Column(name = "fhao", nullable = true, length = 50)
    public String getFhao() {
        return fhao;
    }

    public void setFhao(String fhao) {
        this.fhao = fhao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZSfxmEntity that = (ZSfxmEntity) o;

        if (id != that.id) return false;
        if (sfxm != null ? !sfxm.equals(that.sfxm) : that.sfxm != null) return false;
        if (fhao != null ? !fhao.equals(that.fhao) : that.fhao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sfxm != null ? sfxm.hashCode() : 0);
        result = 31 * result + (fhao != null ? fhao.hashCode() : 0);
        return result;
    }
}
