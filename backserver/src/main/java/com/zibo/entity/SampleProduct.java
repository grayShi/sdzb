package com.zibo.entity;

import com.zibo.constants.SampleStatus;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * 抽样产品信息
 *
 * @author shaoxiong.zhan
 */
@Entity
@Data
@Where(clause = "deleted=0")
public class SampleProduct extends IEntity {
    /**
     * id for sampleData
     */
    @Column(length = 45)
    private String productId = UUID.randomUUID().toString();

    private String wt;
    private String sampleNo;

    private String sampleName;
    /**
     * 校验类型
     */
    private Long examineId;
    private String checkType;

    /**
     * 单元名称
     */
    private String unitName;

    /**
     * 报告号
     */
    private String reportNo;

    /**
     * 商标
     */
    private String mark;

    /**
     * 生产批号
     */
    private String produceNo;

    /**
     * 样品等级
     */
    private Long sampleLevelId;
    private String sampleLevel;

    /**
     * 型号规格
     */
    private String size;


    /**
     * 生产日期
     */
    private String proDate;
    private Timestamp productTime;

    /**
     * 产品标准
     */
    private Long productStandardId;

    @ElementCollection
    private List<String> proStandard;

    /**
     * 校验项目
     */
    private Long examProjectId;
    private String checkPro;

    /**
     * 样品数量
     */
    @Column(nullable = false)
    private int sampleCount = 0;

    /**
     * 存放位置
     */
    private Long storePlaceId;
    private String savePlace;

    /**
     * 备样品存放位置
     */
    private Long storePlaceBackupId;
    private String samplePlace;

    /**
     * 封条数量和号码
     */
    private Integer countNo;

    /**
     * 样品状态
     */
    private String sampleStatus;
    @Enumerated(EnumType.STRING)
    private SampleStatus status = SampleStatus.initial;

    /**
     * 完成时间
     */
    private String completeDate;
    private Timestamp completeTime;

    /**
     * 备样品数量
     */
    private Integer number;//备样品数量

    /**
     * 样品处理方式
     */
    private String handleType;

    /**
     * 抽样/送样
     */
    private String mode;

    /**
     * 抽样地点
     */
    private String samplingPlace;
    /**
     * 抽样方式
     */
    private String samplingWay;

    /**
     * 抽/送样日期
     * yyyy-MM-dd
     */
    private String samDate;

    /**
     * 抽样人
     */
    private String samPeople;

    /**
     * 样品基数/数量
     */
    private Integer samBase;

    /**
     * 企业陪同人
     */
    private String comPeople;

    /**
     * 送样人
     */
    private String sendPeople;

    /**
     * 样品到达时间
     */
    private String reachTime;

    /**
     * 检查封样人员
     */
    private String sealPeople;

    /**
     * 封样状态
     */
    private String sealState;

    /**
     * 入库地点
     */
    private String inStorePlace;

    /**
     * 入库数量
     */
    private Integer inStoreCount;

    public String getSampleStatus() {
        return status.getStatus();
    }
}
