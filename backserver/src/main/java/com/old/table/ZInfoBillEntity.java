package com.old.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ZInfoBill", schema = "dbo", catalog = "shaoxiongtest")
public class ZInfoBillEntity {
    private int id;
    private long rwid;
    private Integer cywtidid;
    private String cywtid;
    private String bgid;
    private Integer bm;
    private String ypname;
    private Integer ypjylx;
    private String ypsb;
    private String ypdj;
    private String ypxh;
    private String ypscph;
    private String ypscdate;
    private String ypcpbz;
    private String ypjyxm;
    private String ypnumber;
    private int ypcfdd;
    private int ypbycfdd;
    private String ypftslhm;
    private Integer ypcl;
    private String ypzt;
    private Timestamp ypjcwcdate;
    private String bysl;
    private Integer ypcysy;
    private String ypcydd;
    private String ypcyfs;
    private Timestamp ypcydate;
    private String ypcyr;
    private String ypcyjs;
    private String ypqyptr;
    private String ypsyr;
    private Timestamp ypdddate;
    private String jcfyr;
    private String fyzt;
    private String flag;
    private String sjyqid;
    private String scqyid;
    private String wtdwid;
    private String rwly;
    private String cydw;
    private Integer bghqfs;
    private Integer txrSession;
    private Integer sfid;
    private Timestamp operdate;
    private String dayinpzname;
    private String lyr;
    private String lyypsl;
    private Timestamp lysj;
    private Integer kcypsl;
    private String tyr;
    private String tysl;
    private Timestamp tyrq;
    private String jydd;
    private Integer isOk;
    private Timestamp ypdjrq;
    private Integer cl;
    private String tylqr;
    private String fflag;
    private String dymc;
    private String sjfzbgh;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rwid", nullable = false)
    public long getRwid() {
        return rwid;
    }

    public void setRwid(long rwid) {
        this.rwid = rwid;
    }

    @Basic
    @Column(name = "cywtidid", nullable = true)
    public Integer getCywtidid() {
        return cywtidid;
    }

    public void setCywtidid(Integer cywtidid) {
        this.cywtidid = cywtidid;
    }

    @Basic
    @Column(name = "cywtid", nullable = true, length = 50)
    public String getCywtid() {
        return cywtid;
    }

    public void setCywtid(String cywtid) {
        this.cywtid = cywtid;
    }

    @Basic
    @Column(name = "bgid", nullable = true, length = 50)
    public String getBgid() {
        return bgid;
    }

    public void setBgid(String bgid) {
        this.bgid = bgid;
    }

    @Basic
    @Column(name = "bm", nullable = true)
    public Integer getBm() {
        return bm;
    }

    public void setBm(Integer bm) {
        this.bm = bm;
    }

    @Basic
    @Column(name = "ypname", nullable = true, length = 2147483647)
    public String getYpname() {
        return ypname;
    }

    public void setYpname(String ypname) {
        this.ypname = ypname;
    }

    @Basic
    @Column(name = "ypjylx", nullable = true)
    public Integer getYpjylx() {
        return ypjylx;
    }

    public void setYpjylx(Integer ypjylx) {
        this.ypjylx = ypjylx;
    }

    @Basic
    @Column(name = "ypsb", nullable = true, length = 50)
    public String getYpsb() {
        return ypsb;
    }

    public void setYpsb(String ypsb) {
        this.ypsb = ypsb;
    }

    @Basic
    @Column(name = "ypdj", nullable = true, length = 50)
    public String getYpdj() {
        return ypdj;
    }

    public void setYpdj(String ypdj) {
        this.ypdj = ypdj;
    }

    @Basic
    @Column(name = "ypxh", nullable = true, length = 2147483647)
    public String getYpxh() {
        return ypxh;
    }

    public void setYpxh(String ypxh) {
        this.ypxh = ypxh;
    }

    @Basic
    @Column(name = "ypscph", nullable = true, length = 50)
    public String getYpscph() {
        return ypscph;
    }

    public void setYpscph(String ypscph) {
        this.ypscph = ypscph;
    }

    @Basic
    @Column(name = "ypscdate", nullable = true, length = 50)
    public String getYpscdate() {
        return ypscdate;
    }

    public void setYpscdate(String ypscdate) {
        this.ypscdate = ypscdate;
    }

    @Basic
    @Column(name = "ypcpbz", nullable = true, length = 2147483647)
    public String getYpcpbz() {
        return ypcpbz;
    }

    public void setYpcpbz(String ypcpbz) {
        this.ypcpbz = ypcpbz;
    }

    @Basic
    @Column(name = "ypjyxm", nullable = true, length = 2147483647)
    public String getYpjyxm() {
        return ypjyxm;
    }

    public void setYpjyxm(String ypjyxm) {
        this.ypjyxm = ypjyxm;
    }

    @Basic
    @Column(name = "ypnumber", nullable = true, length = 50)
    public String getYpnumber() {
        return ypnumber;
    }

    public void setYpnumber(String ypnumber) {
        this.ypnumber = ypnumber;
    }

    @Basic
    @Column(name = "ypcfdd", nullable = false)
    public int getYpcfdd() {
        return ypcfdd;
    }

    public void setYpcfdd(int ypcfdd) {
        this.ypcfdd = ypcfdd;
    }

    @Basic
    @Column(name = "ypbycfdd", nullable = false)
    public int getYpbycfdd() {
        return ypbycfdd;
    }

    public void setYpbycfdd(int ypbycfdd) {
        this.ypbycfdd = ypbycfdd;
    }

    @Basic
    @Column(name = "ypftslhm", nullable = true, length = 50)
    public String getYpftslhm() {
        return ypftslhm;
    }

    public void setYpftslhm(String ypftslhm) {
        this.ypftslhm = ypftslhm;
    }

    @Basic
    @Column(name = "ypcl", nullable = true)
    public Integer getYpcl() {
        return ypcl;
    }

    public void setYpcl(Integer ypcl) {
        this.ypcl = ypcl;
    }

    @Basic
    @Column(name = "ypzt", nullable = true, length = 50)
    public String getYpzt() {
        return ypzt;
    }

    public void setYpzt(String ypzt) {
        this.ypzt = ypzt;
    }

    @Basic
    @Column(name = "ypjcwcdate", nullable = true)
    public Timestamp getYpjcwcdate() {
        return ypjcwcdate;
    }

    public void setYpjcwcdate(Timestamp ypjcwcdate) {
        this.ypjcwcdate = ypjcwcdate;
    }

    @Basic
    @Column(name = "bysl", nullable = true, length = 50)
    public String getBysl() {
        return bysl;
    }

    public void setBysl(String bysl) {
        this.bysl = bysl;
    }

    @Basic
    @Column(name = "ypcysy", nullable = true)
    public Integer getYpcysy() {
        return ypcysy;
    }

    public void setYpcysy(Integer ypcysy) {
        this.ypcysy = ypcysy;
    }

    @Basic
    @Column(name = "ypcydd", nullable = true, length = 50)
    public String getYpcydd() {
        return ypcydd;
    }

    public void setYpcydd(String ypcydd) {
        this.ypcydd = ypcydd;
    }

    @Basic
    @Column(name = "ypcyfs", nullable = true, length = 50)
    public String getYpcyfs() {
        return ypcyfs;
    }

    public void setYpcyfs(String ypcyfs) {
        this.ypcyfs = ypcyfs;
    }

    @Basic
    @Column(name = "ypcydate", nullable = true)
    public Timestamp getYpcydate() {
        return ypcydate;
    }

    public void setYpcydate(Timestamp ypcydate) {
        this.ypcydate = ypcydate;
    }

    @Basic
    @Column(name = "ypcyr", nullable = true, length = 50)
    public String getYpcyr() {
        return ypcyr;
    }

    public void setYpcyr(String ypcyr) {
        this.ypcyr = ypcyr;
    }

    @Basic
    @Column(name = "ypcyjs", nullable = true, length = 50)
    public String getYpcyjs() {
        return ypcyjs;
    }

    public void setYpcyjs(String ypcyjs) {
        this.ypcyjs = ypcyjs;
    }

    @Basic
    @Column(name = "ypqyptr", nullable = true, length = 50)
    public String getYpqyptr() {
        return ypqyptr;
    }

    public void setYpqyptr(String ypqyptr) {
        this.ypqyptr = ypqyptr;
    }

    @Basic
    @Column(name = "ypsyr", nullable = true, length = 50)
    public String getYpsyr() {
        return ypsyr;
    }

    public void setYpsyr(String ypsyr) {
        this.ypsyr = ypsyr;
    }

    @Basic
    @Column(name = "ypdddate", nullable = true)
    public Timestamp getYpdddate() {
        return ypdddate;
    }

    public void setYpdddate(Timestamp ypdddate) {
        this.ypdddate = ypdddate;
    }

    @Basic
    @Column(name = "jcfyr", nullable = true, length = 50)
    public String getJcfyr() {
        return jcfyr;
    }

    public void setJcfyr(String jcfyr) {
        this.jcfyr = jcfyr;
    }

    @Basic
    @Column(name = "fyzt", nullable = true, length = 50)
    public String getFyzt() {
        return fyzt;
    }

    public void setFyzt(String fyzt) {
        this.fyzt = fyzt;
    }

    @Basic
    @Column(name = "flag", nullable = true, length = 50)
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "sjyqid", nullable = true, length = 300)
    public String getSjyqid() {
        return sjyqid;
    }

    public void setSjyqid(String sjyqid) {
        this.sjyqid = sjyqid;
    }

    @Basic
    @Column(name = "scqyid", nullable = true, length = 300)
    public String getScqyid() {
        return scqyid;
    }

    public void setScqyid(String scqyid) {
        this.scqyid = scqyid;
    }

    @Basic
    @Column(name = "wtdwid", nullable = true, length = 300)
    public String getWtdwid() {
        return wtdwid;
    }

    public void setWtdwid(String wtdwid) {
        this.wtdwid = wtdwid;
    }

    @Basic
    @Column(name = "rwly", nullable = true, length = 50)
    public String getRwly() {
        return rwly;
    }

    public void setRwly(String rwly) {
        this.rwly = rwly;
    }

    @Basic
    @Column(name = "cydw", nullable = true, length = 50)
    public String getCydw() {
        return cydw;
    }

    public void setCydw(String cydw) {
        this.cydw = cydw;
    }

    @Basic
    @Column(name = "bghqfs", nullable = true)
    public Integer getBghqfs() {
        return bghqfs;
    }

    public void setBghqfs(Integer bghqfs) {
        this.bghqfs = bghqfs;
    }

    @Basic
    @Column(name = "TxrSession", nullable = true)
    public Integer getTxrSession() {
        return txrSession;
    }

    public void setTxrSession(Integer txrSession) {
        this.txrSession = txrSession;
    }

    @Basic
    @Column(name = "sfid", nullable = true)
    public Integer getSfid() {
        return sfid;
    }

    public void setSfid(Integer sfid) {
        this.sfid = sfid;
    }

    @Basic
    @Column(name = "operdate", nullable = true)
    public Timestamp getOperdate() {
        return operdate;
    }

    public void setOperdate(Timestamp operdate) {
        this.operdate = operdate;
    }

    @Basic
    @Column(name = "dayinpzname", nullable = true, length = 50)
    public String getDayinpzname() {
        return dayinpzname;
    }

    public void setDayinpzname(String dayinpzname) {
        this.dayinpzname = dayinpzname;
    }

    @Basic
    @Column(name = "lyr", nullable = true, length = 10)
    public String getLyr() {
        return lyr;
    }

    public void setLyr(String lyr) {
        this.lyr = lyr;
    }

    @Basic
    @Column(name = "lyypsl", nullable = true, length = 500)
    public String getLyypsl() {
        return lyypsl;
    }

    public void setLyypsl(String lyypsl) {
        this.lyypsl = lyypsl;
    }

    @Basic
    @Column(name = "lysj", nullable = true)
    public Timestamp getLysj() {
        return lysj;
    }

    public void setLysj(Timestamp lysj) {
        this.lysj = lysj;
    }

    @Basic
    @Column(name = "kcypsl", nullable = true)
    public Integer getKcypsl() {
        return kcypsl;
    }

    public void setKcypsl(Integer kcypsl) {
        this.kcypsl = kcypsl;
    }

    @Basic
    @Column(name = "tyr", nullable = true, length = 100)
    public String getTyr() {
        return tyr;
    }

    public void setTyr(String tyr) {
        this.tyr = tyr;
    }

    @Basic
    @Column(name = "tysl", nullable = true, length = 500)
    public String getTysl() {
        return tysl;
    }

    public void setTysl(String tysl) {
        this.tysl = tysl;
    }

    @Basic
    @Column(name = "tyrq", nullable = true)
    public Timestamp getTyrq() {
        return tyrq;
    }

    public void setTyrq(Timestamp tyrq) {
        this.tyrq = tyrq;
    }

    @Basic
    @Column(name = "jydd", nullable = true, length = 200)
    public String getJydd() {
        return jydd;
    }

    public void setJydd(String jydd) {
        this.jydd = jydd;
    }

    @Basic
    @Column(name = "isOk", nullable = true)
    public Integer getIsOk() {
        return isOk;
    }

    public void setIsOk(Integer isOk) {
        this.isOk = isOk;
    }

    @Basic
    @Column(name = "ypdjrq", nullable = true)
    public Timestamp getYpdjrq() {
        return ypdjrq;
    }

    public void setYpdjrq(Timestamp ypdjrq) {
        this.ypdjrq = ypdjrq;
    }

    @Basic
    @Column(name = "Cl", nullable = true)
    public Integer getCl() {
        return cl;
    }

    public void setCl(Integer cl) {
        this.cl = cl;
    }

    @Basic
    @Column(name = "tylqr", nullable = true, length = 20)
    public String getTylqr() {
        return tylqr;
    }

    public void setTylqr(String tylqr) {
        this.tylqr = tylqr;
    }

    @Basic
    @Column(name = "fflag", nullable = true, length = 20)
    public String getFflag() {
        return fflag;
    }

    public void setFflag(String fflag) {
        this.fflag = fflag;
    }

    @Basic
    @Column(name = "dymc", nullable = true, length = 50)
    public String getDymc() {
        return dymc;
    }

    public void setDymc(String dymc) {
        this.dymc = dymc;
    }

    @Basic
    @Column(name = "sjfzbgh", nullable = true, length = 50)
    public String getSjfzbgh() {
        return sjfzbgh;
    }

    public void setSjfzbgh(String sjfzbgh) {
        this.sjfzbgh = sjfzbgh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZInfoBillEntity that = (ZInfoBillEntity) o;

        if (id != that.id) return false;
        if (rwid != that.rwid) return false;
        if (ypcfdd != that.ypcfdd) return false;
        if (ypbycfdd != that.ypbycfdd) return false;
        if (cywtidid != null ? !cywtidid.equals(that.cywtidid) : that.cywtidid != null) return false;
        if (cywtid != null ? !cywtid.equals(that.cywtid) : that.cywtid != null) return false;
        if (bgid != null ? !bgid.equals(that.bgid) : that.bgid != null) return false;
        if (bm != null ? !bm.equals(that.bm) : that.bm != null) return false;
        if (ypname != null ? !ypname.equals(that.ypname) : that.ypname != null) return false;
        if (ypjylx != null ? !ypjylx.equals(that.ypjylx) : that.ypjylx != null) return false;
        if (ypsb != null ? !ypsb.equals(that.ypsb) : that.ypsb != null) return false;
        if (ypdj != null ? !ypdj.equals(that.ypdj) : that.ypdj != null) return false;
        if (ypxh != null ? !ypxh.equals(that.ypxh) : that.ypxh != null) return false;
        if (ypscph != null ? !ypscph.equals(that.ypscph) : that.ypscph != null) return false;
        if (ypscdate != null ? !ypscdate.equals(that.ypscdate) : that.ypscdate != null) return false;
        if (ypcpbz != null ? !ypcpbz.equals(that.ypcpbz) : that.ypcpbz != null) return false;
        if (ypjyxm != null ? !ypjyxm.equals(that.ypjyxm) : that.ypjyxm != null) return false;
        if (ypnumber != null ? !ypnumber.equals(that.ypnumber) : that.ypnumber != null) return false;
        if (ypftslhm != null ? !ypftslhm.equals(that.ypftslhm) : that.ypftslhm != null) return false;
        if (ypcl != null ? !ypcl.equals(that.ypcl) : that.ypcl != null) return false;
        if (ypzt != null ? !ypzt.equals(that.ypzt) : that.ypzt != null) return false;
        if (ypjcwcdate != null ? !ypjcwcdate.equals(that.ypjcwcdate) : that.ypjcwcdate != null) return false;
        if (bysl != null ? !bysl.equals(that.bysl) : that.bysl != null) return false;
        if (ypcysy != null ? !ypcysy.equals(that.ypcysy) : that.ypcysy != null) return false;
        if (ypcydd != null ? !ypcydd.equals(that.ypcydd) : that.ypcydd != null) return false;
        if (ypcyfs != null ? !ypcyfs.equals(that.ypcyfs) : that.ypcyfs != null) return false;
        if (ypcydate != null ? !ypcydate.equals(that.ypcydate) : that.ypcydate != null) return false;
        if (ypcyr != null ? !ypcyr.equals(that.ypcyr) : that.ypcyr != null) return false;
        if (ypcyjs != null ? !ypcyjs.equals(that.ypcyjs) : that.ypcyjs != null) return false;
        if (ypqyptr != null ? !ypqyptr.equals(that.ypqyptr) : that.ypqyptr != null) return false;
        if (ypsyr != null ? !ypsyr.equals(that.ypsyr) : that.ypsyr != null) return false;
        if (ypdddate != null ? !ypdddate.equals(that.ypdddate) : that.ypdddate != null) return false;
        if (jcfyr != null ? !jcfyr.equals(that.jcfyr) : that.jcfyr != null) return false;
        if (fyzt != null ? !fyzt.equals(that.fyzt) : that.fyzt != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;
        if (sjyqid != null ? !sjyqid.equals(that.sjyqid) : that.sjyqid != null) return false;
        if (scqyid != null ? !scqyid.equals(that.scqyid) : that.scqyid != null) return false;
        if (wtdwid != null ? !wtdwid.equals(that.wtdwid) : that.wtdwid != null) return false;
        if (rwly != null ? !rwly.equals(that.rwly) : that.rwly != null) return false;
        if (cydw != null ? !cydw.equals(that.cydw) : that.cydw != null) return false;
        if (bghqfs != null ? !bghqfs.equals(that.bghqfs) : that.bghqfs != null) return false;
        if (txrSession != null ? !txrSession.equals(that.txrSession) : that.txrSession != null) return false;
        if (sfid != null ? !sfid.equals(that.sfid) : that.sfid != null) return false;
        if (operdate != null ? !operdate.equals(that.operdate) : that.operdate != null) return false;
        if (dayinpzname != null ? !dayinpzname.equals(that.dayinpzname) : that.dayinpzname != null) return false;
        if (lyr != null ? !lyr.equals(that.lyr) : that.lyr != null) return false;
        if (lyypsl != null ? !lyypsl.equals(that.lyypsl) : that.lyypsl != null) return false;
        if (lysj != null ? !lysj.equals(that.lysj) : that.lysj != null) return false;
        if (kcypsl != null ? !kcypsl.equals(that.kcypsl) : that.kcypsl != null) return false;
        if (tyr != null ? !tyr.equals(that.tyr) : that.tyr != null) return false;
        if (tysl != null ? !tysl.equals(that.tysl) : that.tysl != null) return false;
        if (tyrq != null ? !tyrq.equals(that.tyrq) : that.tyrq != null) return false;
        if (jydd != null ? !jydd.equals(that.jydd) : that.jydd != null) return false;
        if (isOk != null ? !isOk.equals(that.isOk) : that.isOk != null) return false;
        if (ypdjrq != null ? !ypdjrq.equals(that.ypdjrq) : that.ypdjrq != null) return false;
        if (cl != null ? !cl.equals(that.cl) : that.cl != null) return false;
        if (tylqr != null ? !tylqr.equals(that.tylqr) : that.tylqr != null) return false;
        if (fflag != null ? !fflag.equals(that.fflag) : that.fflag != null) return false;
        if (dymc != null ? !dymc.equals(that.dymc) : that.dymc != null) return false;
        if (sjfzbgh != null ? !sjfzbgh.equals(that.sjfzbgh) : that.sjfzbgh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) (rwid ^ (rwid >>> 32));
        result = 31 * result + (cywtidid != null ? cywtidid.hashCode() : 0);
        result = 31 * result + (cywtid != null ? cywtid.hashCode() : 0);
        result = 31 * result + (bgid != null ? bgid.hashCode() : 0);
        result = 31 * result + (bm != null ? bm.hashCode() : 0);
        result = 31 * result + (ypname != null ? ypname.hashCode() : 0);
        result = 31 * result + (ypjylx != null ? ypjylx.hashCode() : 0);
        result = 31 * result + (ypsb != null ? ypsb.hashCode() : 0);
        result = 31 * result + (ypdj != null ? ypdj.hashCode() : 0);
        result = 31 * result + (ypxh != null ? ypxh.hashCode() : 0);
        result = 31 * result + (ypscph != null ? ypscph.hashCode() : 0);
        result = 31 * result + (ypscdate != null ? ypscdate.hashCode() : 0);
        result = 31 * result + (ypcpbz != null ? ypcpbz.hashCode() : 0);
        result = 31 * result + (ypjyxm != null ? ypjyxm.hashCode() : 0);
        result = 31 * result + (ypnumber != null ? ypnumber.hashCode() : 0);
        result = 31 * result + ypcfdd;
        result = 31 * result + ypbycfdd;
        result = 31 * result + (ypftslhm != null ? ypftslhm.hashCode() : 0);
        result = 31 * result + (ypcl != null ? ypcl.hashCode() : 0);
        result = 31 * result + (ypzt != null ? ypzt.hashCode() : 0);
        result = 31 * result + (ypjcwcdate != null ? ypjcwcdate.hashCode() : 0);
        result = 31 * result + (bysl != null ? bysl.hashCode() : 0);
        result = 31 * result + (ypcysy != null ? ypcysy.hashCode() : 0);
        result = 31 * result + (ypcydd != null ? ypcydd.hashCode() : 0);
        result = 31 * result + (ypcyfs != null ? ypcyfs.hashCode() : 0);
        result = 31 * result + (ypcydate != null ? ypcydate.hashCode() : 0);
        result = 31 * result + (ypcyr != null ? ypcyr.hashCode() : 0);
        result = 31 * result + (ypcyjs != null ? ypcyjs.hashCode() : 0);
        result = 31 * result + (ypqyptr != null ? ypqyptr.hashCode() : 0);
        result = 31 * result + (ypsyr != null ? ypsyr.hashCode() : 0);
        result = 31 * result + (ypdddate != null ? ypdddate.hashCode() : 0);
        result = 31 * result + (jcfyr != null ? jcfyr.hashCode() : 0);
        result = 31 * result + (fyzt != null ? fyzt.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (sjyqid != null ? sjyqid.hashCode() : 0);
        result = 31 * result + (scqyid != null ? scqyid.hashCode() : 0);
        result = 31 * result + (wtdwid != null ? wtdwid.hashCode() : 0);
        result = 31 * result + (rwly != null ? rwly.hashCode() : 0);
        result = 31 * result + (cydw != null ? cydw.hashCode() : 0);
        result = 31 * result + (bghqfs != null ? bghqfs.hashCode() : 0);
        result = 31 * result + (txrSession != null ? txrSession.hashCode() : 0);
        result = 31 * result + (sfid != null ? sfid.hashCode() : 0);
        result = 31 * result + (operdate != null ? operdate.hashCode() : 0);
        result = 31 * result + (dayinpzname != null ? dayinpzname.hashCode() : 0);
        result = 31 * result + (lyr != null ? lyr.hashCode() : 0);
        result = 31 * result + (lyypsl != null ? lyypsl.hashCode() : 0);
        result = 31 * result + (lysj != null ? lysj.hashCode() : 0);
        result = 31 * result + (kcypsl != null ? kcypsl.hashCode() : 0);
        result = 31 * result + (tyr != null ? tyr.hashCode() : 0);
        result = 31 * result + (tysl != null ? tysl.hashCode() : 0);
        result = 31 * result + (tyrq != null ? tyrq.hashCode() : 0);
        result = 31 * result + (jydd != null ? jydd.hashCode() : 0);
        result = 31 * result + (isOk != null ? isOk.hashCode() : 0);
        result = 31 * result + (ypdjrq != null ? ypdjrq.hashCode() : 0);
        result = 31 * result + (cl != null ? cl.hashCode() : 0);
        result = 31 * result + (tylqr != null ? tylqr.hashCode() : 0);
        result = 31 * result + (fflag != null ? fflag.hashCode() : 0);
        result = 31 * result + (dymc != null ? dymc.hashCode() : 0);
        result = 31 * result + (sjfzbgh != null ? sjfzbgh.hashCode() : 0);
        return result;
    }
}
