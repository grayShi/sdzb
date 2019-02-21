package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "Equipment", schema = "dbo", catalog = "shaoxiongtest")
public class EquipmentEntity {
    private int id;
    private String snNum;
    private String yqName;
    private String ggxx;
    private String lc;
    private String zqd;
    private String fbl;
    private String zzdw;
    private String ccBianHao;
    private String sbyz;
    private Timestamp gmDate;
    private String jyDate;
    private String jydw;
    private String whzqy;
    private String jylx;
    private String jyfs;
    private String jys;
    private String cfd;
    private String qjhcsj;
    private String jdJzBj;
    private String jzcsfw;
    private String sjxhc;
    private String problem;
    private String jdf;
    private Timestamp first;
    private Timestamp scend;
    private Timestamp third;
    private Timestamp four;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SnNum", nullable = true, length = 50)
    public String getSnNum() {
        return snNum;
    }

    public void setSnNum(String snNum) {
        this.snNum = snNum;
    }

    @Basic
    @Column(name = "YqName", nullable = true, length = 50)
    public String getYqName() {
        return yqName;
    }

    public void setYqName(String yqName) {
        this.yqName = yqName;
    }

    @Basic
    @Column(name = "Ggxx", nullable = true, length = 50)
    public String getGgxx() {
        return ggxx;
    }

    public void setGgxx(String ggxx) {
        this.ggxx = ggxx;
    }

    @Basic
    @Column(name = "Lc", nullable = true, length = 50)
    public String getLc() {
        return lc;
    }

    public void setLc(String lc) {
        this.lc = lc;
    }

    @Basic
    @Column(name = "Zqd", nullable = true, length = 20)
    public String getZqd() {
        return zqd;
    }

    public void setZqd(String zqd) {
        this.zqd = zqd;
    }

    @Basic
    @Column(name = "Fbl", nullable = true, length = 20)
    public String getFbl() {
        return fbl;
    }

    public void setFbl(String fbl) {
        this.fbl = fbl;
    }

    @Basic
    @Column(name = "Zzdw", nullable = true, length = 20)
    public String getZzdw() {
        return zzdw;
    }

    public void setZzdw(String zzdw) {
        this.zzdw = zzdw;
    }

    @Basic
    @Column(name = "CcBianHao", nullable = true, length = 20)
    public String getCcBianHao() {
        return ccBianHao;
    }

    public void setCcBianHao(String ccBianHao) {
        this.ccBianHao = ccBianHao;
    }

    @Basic
    @Column(name = "Sbyz", nullable = true, length = 20)
    public String getSbyz() {
        return sbyz;
    }

    public void setSbyz(String sbyz) {
        this.sbyz = sbyz;
    }

    @Basic
    @Column(name = "GmDate", nullable = true)
    public Timestamp getGmDate() {
        return gmDate;
    }

    public void setGmDate(Timestamp gmDate) {
        this.gmDate = gmDate;
    }

    @Basic
    @Column(name = "JyDate", nullable = true, length = 20)
    public String getJyDate() {
        return jyDate;
    }

    public void setJyDate(String jyDate) {
        this.jyDate = jyDate;
    }

    @Basic
    @Column(name = "Jydw", nullable = true, length = 20)
    public String getJydw() {
        return jydw;
    }

    public void setJydw(String jydw) {
        this.jydw = jydw;
    }

    @Basic
    @Column(name = "whzqy", nullable = true, length = 20)
    public String getWhzqy() {
        return whzqy;
    }

    public void setWhzqy(String whzqy) {
        this.whzqy = whzqy;
    }

    @Basic
    @Column(name = "Jylx", nullable = true, length = 10)
    public String getJylx() {
        return jylx;
    }

    public void setJylx(String jylx) {
        this.jylx = jylx;
    }

    @Basic
    @Column(name = "Jyfs", nullable = true, length = 10)
    public String getJyfs() {
        return jyfs;
    }

    public void setJyfs(String jyfs) {
        this.jyfs = jyfs;
    }

    @Basic
    @Column(name = "Jys", nullable = true, length = 10)
    public String getJys() {
        return jys;
    }

    public void setJys(String jys) {
        this.jys = jys;
    }

    @Basic
    @Column(name = "Cfd", nullable = true, length = 10)
    public String getCfd() {
        return cfd;
    }

    public void setCfd(String cfd) {
        this.cfd = cfd;
    }

    @Basic
    @Column(name = "Qjhcsj", nullable = true, length = 20)
    public String getQjhcsj() {
        return qjhcsj;
    }

    public void setQjhcsj(String qjhcsj) {
        this.qjhcsj = qjhcsj;
    }

    @Basic
    @Column(name = "JdJzBj", nullable = true, length = 10)
    public String getJdJzBj() {
        return jdJzBj;
    }

    public void setJdJzBj(String jdJzBj) {
        this.jdJzBj = jdJzBj;
    }

    @Basic
    @Column(name = "Jzcsfw", nullable = true, length = 10)
    public String getJzcsfw() {
        return jzcsfw;
    }

    public void setJzcsfw(String jzcsfw) {
        this.jzcsfw = jzcsfw;
    }

    @Basic
    @Column(name = "Sjxhc", nullable = true, length = 50)
    public String getSjxhc() {
        return sjxhc;
    }

    public void setSjxhc(String sjxhc) {
        this.sjxhc = sjxhc;
    }

    @Basic
    @Column(name = "Problem", nullable = true, length = 50)
    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Basic
    @Column(name = "Jdf", nullable = true, length = 50)
    public String getJdf() {
        return jdf;
    }

    public void setJdf(String jdf) {
        this.jdf = jdf;
    }

    @Basic
    @Column(name = "first", nullable = true)
    public Timestamp getFirst() {
        return first;
    }

    public void setFirst(Timestamp first) {
        this.first = first;
    }

    @Basic
    @Column(name = "scend", nullable = true)
    public Timestamp getScend() {
        return scend;
    }

    public void setScend(Timestamp scend) {
        this.scend = scend;
    }

    @Basic
    @Column(name = "third", nullable = true)
    public Timestamp getThird() {
        return third;
    }

    public void setThird(Timestamp third) {
        this.third = third;
    }

    @Basic
    @Column(name = "four", nullable = true)
    public Timestamp getFour() {
        return four;
    }

    public void setFour(Timestamp four) {
        this.four = four;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentEntity that = (EquipmentEntity) o;

        if (id != that.id) return false;
        if (snNum != null ? !snNum.equals(that.snNum) : that.snNum != null) return false;
        if (yqName != null ? !yqName.equals(that.yqName) : that.yqName != null) return false;
        if (ggxx != null ? !ggxx.equals(that.ggxx) : that.ggxx != null) return false;
        if (lc != null ? !lc.equals(that.lc) : that.lc != null) return false;
        if (zqd != null ? !zqd.equals(that.zqd) : that.zqd != null) return false;
        if (fbl != null ? !fbl.equals(that.fbl) : that.fbl != null) return false;
        if (zzdw != null ? !zzdw.equals(that.zzdw) : that.zzdw != null) return false;
        if (ccBianHao != null ? !ccBianHao.equals(that.ccBianHao) : that.ccBianHao != null) return false;
        if (sbyz != null ? !sbyz.equals(that.sbyz) : that.sbyz != null) return false;
        if (gmDate != null ? !gmDate.equals(that.gmDate) : that.gmDate != null) return false;
        if (jyDate != null ? !jyDate.equals(that.jyDate) : that.jyDate != null) return false;
        if (jydw != null ? !jydw.equals(that.jydw) : that.jydw != null) return false;
        if (whzqy != null ? !whzqy.equals(that.whzqy) : that.whzqy != null) return false;
        if (jylx != null ? !jylx.equals(that.jylx) : that.jylx != null) return false;
        if (jyfs != null ? !jyfs.equals(that.jyfs) : that.jyfs != null) return false;
        if (jys != null ? !jys.equals(that.jys) : that.jys != null) return false;
        if (cfd != null ? !cfd.equals(that.cfd) : that.cfd != null) return false;
        if (qjhcsj != null ? !qjhcsj.equals(that.qjhcsj) : that.qjhcsj != null) return false;
        if (jdJzBj != null ? !jdJzBj.equals(that.jdJzBj) : that.jdJzBj != null) return false;
        if (jzcsfw != null ? !jzcsfw.equals(that.jzcsfw) : that.jzcsfw != null) return false;
        if (sjxhc != null ? !sjxhc.equals(that.sjxhc) : that.sjxhc != null) return false;
        if (problem != null ? !problem.equals(that.problem) : that.problem != null) return false;
        if (jdf != null ? !jdf.equals(that.jdf) : that.jdf != null) return false;
        if (first != null ? !first.equals(that.first) : that.first != null) return false;
        if (scend != null ? !scend.equals(that.scend) : that.scend != null) return false;
        if (third != null ? !third.equals(that.third) : that.third != null) return false;
        if (four != null ? !four.equals(that.four) : that.four != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (snNum != null ? snNum.hashCode() : 0);
        result = 31 * result + (yqName != null ? yqName.hashCode() : 0);
        result = 31 * result + (ggxx != null ? ggxx.hashCode() : 0);
        result = 31 * result + (lc != null ? lc.hashCode() : 0);
        result = 31 * result + (zqd != null ? zqd.hashCode() : 0);
        result = 31 * result + (fbl != null ? fbl.hashCode() : 0);
        result = 31 * result + (zzdw != null ? zzdw.hashCode() : 0);
        result = 31 * result + (ccBianHao != null ? ccBianHao.hashCode() : 0);
        result = 31 * result + (sbyz != null ? sbyz.hashCode() : 0);
        result = 31 * result + (gmDate != null ? gmDate.hashCode() : 0);
        result = 31 * result + (jyDate != null ? jyDate.hashCode() : 0);
        result = 31 * result + (jydw != null ? jydw.hashCode() : 0);
        result = 31 * result + (whzqy != null ? whzqy.hashCode() : 0);
        result = 31 * result + (jylx != null ? jylx.hashCode() : 0);
        result = 31 * result + (jyfs != null ? jyfs.hashCode() : 0);
        result = 31 * result + (jys != null ? jys.hashCode() : 0);
        result = 31 * result + (cfd != null ? cfd.hashCode() : 0);
        result = 31 * result + (qjhcsj != null ? qjhcsj.hashCode() : 0);
        result = 31 * result + (jdJzBj != null ? jdJzBj.hashCode() : 0);
        result = 31 * result + (jzcsfw != null ? jzcsfw.hashCode() : 0);
        result = 31 * result + (sjxhc != null ? sjxhc.hashCode() : 0);
        result = 31 * result + (problem != null ? problem.hashCode() : 0);
        result = 31 * result + (jdf != null ? jdf.hashCode() : 0);
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (scend != null ? scend.hashCode() : 0);
        result = 31 * result + (third != null ? third.hashCode() : 0);
        result = 31 * result + (four != null ? four.hashCode() : 0);
        return result;
    }
}
