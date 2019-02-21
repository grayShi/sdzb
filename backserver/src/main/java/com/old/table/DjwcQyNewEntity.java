package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DjwcQyNew", schema = "dbo", catalog = "shaoxiongtest")
public class DjwcQyNewEntity {
    private int id;
    private String hhaspxXuhao;
    private String hhaspxQymc;
    private String hhaspxCpmc;
    private String hhaspxQyzzjgdm;
    private String hhaspxJysj;
    private String hhaspxMuljb;
    private String hhaspxSspc;
    private String hhaspxJcjjg;
    private String hhaspxBz;
    private String hhaspxNf;
    private String hhaspxSbn;
    private String hhaspxXbn;
    private String hhaspxDeptid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hhaspx_xuhao", nullable = true, length = 50)
    public String getHhaspxXuhao() {
        return hhaspxXuhao;
    }

    public void setHhaspxXuhao(String hhaspxXuhao) {
        this.hhaspxXuhao = hhaspxXuhao;
    }

    @Basic
    @Column(name = "hhaspx_qymc", nullable = true, length = 50)
    public String getHhaspxQymc() {
        return hhaspxQymc;
    }

    public void setHhaspxQymc(String hhaspxQymc) {
        this.hhaspxQymc = hhaspxQymc;
    }

    @Basic
    @Column(name = "hhaspx_cpmc", nullable = true, length = 2147483647)
    public String getHhaspxCpmc() {
        return hhaspxCpmc;
    }

    public void setHhaspxCpmc(String hhaspxCpmc) {
        this.hhaspxCpmc = hhaspxCpmc;
    }

    @Basic
    @Column(name = "hhaspx_qyzzjgdm", nullable = true, length = 50)
    public String getHhaspxQyzzjgdm() {
        return hhaspxQyzzjgdm;
    }

    public void setHhaspxQyzzjgdm(String hhaspxQyzzjgdm) {
        this.hhaspxQyzzjgdm = hhaspxQyzzjgdm;
    }

    @Basic
    @Column(name = "hhaspx_jysj", nullable = true, length = 2147483647)
    public String getHhaspxJysj() {
        return hhaspxJysj;
    }

    public void setHhaspxJysj(String hhaspxJysj) {
        this.hhaspxJysj = hhaspxJysj;
    }

    @Basic
    @Column(name = "hhaspx_muljb", nullable = true, length = 50)
    public String getHhaspxMuljb() {
        return hhaspxMuljb;
    }

    public void setHhaspxMuljb(String hhaspxMuljb) {
        this.hhaspxMuljb = hhaspxMuljb;
    }

    @Basic
    @Column(name = "hhaspx_sspc", nullable = true, length = 50)
    public String getHhaspxSspc() {
        return hhaspxSspc;
    }

    public void setHhaspxSspc(String hhaspxSspc) {
        this.hhaspxSspc = hhaspxSspc;
    }

    @Basic
    @Column(name = "hhaspx_jcjjg", nullable = true, length = 50)
    public String getHhaspxJcjjg() {
        return hhaspxJcjjg;
    }

    public void setHhaspxJcjjg(String hhaspxJcjjg) {
        this.hhaspxJcjjg = hhaspxJcjjg;
    }

    @Basic
    @Column(name = "hhaspx_bz", nullable = true, length = 50)
    public String getHhaspxBz() {
        return hhaspxBz;
    }

    public void setHhaspxBz(String hhaspxBz) {
        this.hhaspxBz = hhaspxBz;
    }

    @Basic
    @Column(name = "hhaspx_nf", nullable = true, length = 4)
    public String getHhaspxNf() {
        return hhaspxNf;
    }

    public void setHhaspxNf(String hhaspxNf) {
        this.hhaspxNf = hhaspxNf;
    }

    @Basic
    @Column(name = "hhaspx_sbn", nullable = true, length = 50)
    public String getHhaspxSbn() {
        return hhaspxSbn;
    }

    public void setHhaspxSbn(String hhaspxSbn) {
        this.hhaspxSbn = hhaspxSbn;
    }

    @Basic
    @Column(name = "hhaspx_xbn", nullable = true, length = 50)
    public String getHhaspxXbn() {
        return hhaspxXbn;
    }

    public void setHhaspxXbn(String hhaspxXbn) {
        this.hhaspxXbn = hhaspxXbn;
    }

    @Basic
    @Column(name = "hhaspx_deptid", nullable = true, length = 10)
    public String getHhaspxDeptid() {
        return hhaspxDeptid;
    }

    public void setHhaspxDeptid(String hhaspxDeptid) {
        this.hhaspxDeptid = hhaspxDeptid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DjwcQyNewEntity that = (DjwcQyNewEntity) o;

        if (id != that.id) return false;
        if (hhaspxXuhao != null ? !hhaspxXuhao.equals(that.hhaspxXuhao) : that.hhaspxXuhao != null) return false;
        if (hhaspxQymc != null ? !hhaspxQymc.equals(that.hhaspxQymc) : that.hhaspxQymc != null) return false;
        if (hhaspxCpmc != null ? !hhaspxCpmc.equals(that.hhaspxCpmc) : that.hhaspxCpmc != null) return false;
        if (hhaspxQyzzjgdm != null ? !hhaspxQyzzjgdm.equals(that.hhaspxQyzzjgdm) : that.hhaspxQyzzjgdm != null) return false;
        if (hhaspxJysj != null ? !hhaspxJysj.equals(that.hhaspxJysj) : that.hhaspxJysj != null) return false;
        if (hhaspxMuljb != null ? !hhaspxMuljb.equals(that.hhaspxMuljb) : that.hhaspxMuljb != null) return false;
        if (hhaspxSspc != null ? !hhaspxSspc.equals(that.hhaspxSspc) : that.hhaspxSspc != null) return false;
        if (hhaspxJcjjg != null ? !hhaspxJcjjg.equals(that.hhaspxJcjjg) : that.hhaspxJcjjg != null) return false;
        if (hhaspxBz != null ? !hhaspxBz.equals(that.hhaspxBz) : that.hhaspxBz != null) return false;
        if (hhaspxNf != null ? !hhaspxNf.equals(that.hhaspxNf) : that.hhaspxNf != null) return false;
        if (hhaspxSbn != null ? !hhaspxSbn.equals(that.hhaspxSbn) : that.hhaspxSbn != null) return false;
        if (hhaspxXbn != null ? !hhaspxXbn.equals(that.hhaspxXbn) : that.hhaspxXbn != null) return false;
        if (hhaspxDeptid != null ? !hhaspxDeptid.equals(that.hhaspxDeptid) : that.hhaspxDeptid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (hhaspxXuhao != null ? hhaspxXuhao.hashCode() : 0);
        result = 31 * result + (hhaspxQymc != null ? hhaspxQymc.hashCode() : 0);
        result = 31 * result + (hhaspxCpmc != null ? hhaspxCpmc.hashCode() : 0);
        result = 31 * result + (hhaspxQyzzjgdm != null ? hhaspxQyzzjgdm.hashCode() : 0);
        result = 31 * result + (hhaspxJysj != null ? hhaspxJysj.hashCode() : 0);
        result = 31 * result + (hhaspxMuljb != null ? hhaspxMuljb.hashCode() : 0);
        result = 31 * result + (hhaspxSspc != null ? hhaspxSspc.hashCode() : 0);
        result = 31 * result + (hhaspxJcjjg != null ? hhaspxJcjjg.hashCode() : 0);
        result = 31 * result + (hhaspxBz != null ? hhaspxBz.hashCode() : 0);
        result = 31 * result + (hhaspxNf != null ? hhaspxNf.hashCode() : 0);
        result = 31 * result + (hhaspxSbn != null ? hhaspxSbn.hashCode() : 0);
        result = 31 * result + (hhaspxXbn != null ? hhaspxXbn.hashCode() : 0);
        result = 31 * result + (hhaspxDeptid != null ? hhaspxDeptid.hashCode() : 0);
        return result;
    }
}
