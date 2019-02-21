package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZBiaoZ", schema = "dbo", catalog = "shaoxiongtest")
public class ZBiaoZEntity {
    private int id;
    private String biaozhiname;
    private String biaozhiimagesr;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "biaozhiname", nullable = true, length = 50)
    public String getBiaozhiname() {
        return biaozhiname;
    }

    public void setBiaozhiname(String biaozhiname) {
        this.biaozhiname = biaozhiname;
    }

    @Basic
    @Column(name = "biaozhiimagesr", nullable = true, length = 50)
    public String getBiaozhiimagesr() {
        return biaozhiimagesr;
    }

    public void setBiaozhiimagesr(String biaozhiimagesr) {
        this.biaozhiimagesr = biaozhiimagesr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZBiaoZEntity that = (ZBiaoZEntity) o;

        if (id != that.id) return false;
        if (biaozhiname != null ? !biaozhiname.equals(that.biaozhiname) : that.biaozhiname != null) return false;
        if (biaozhiimagesr != null ? !biaozhiimagesr.equals(that.biaozhiimagesr) : that.biaozhiimagesr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (biaozhiname != null ? biaozhiname.hashCode() : 0);
        result = 31 * result + (biaozhiimagesr != null ? biaozhiimagesr.hashCode() : 0);
        return result;
    }
}
