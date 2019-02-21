package com.zibo.entity;

import com.google.common.collect.Lists;
import com.zibo.constants.SampleStatus;
import com.zibo.constants.SampleType;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.UUID;

/**
 * @author shaoxiong.zhan
 */
@Entity
@Data
@Where(clause = "deleted=0")
public class SampleData extends IEntity {
    @Column(length = 45)
    private String sampleId = UUID.randomUUID().toString();

    @Enumerated(EnumType.STRING)
    private SampleStatus sampleStatus = SampleStatus.initial;
    /**
     * 特殊符号
     */
    private String specialSymbol;
    private Long deptId;
    private String department;
    @Enumerated(EnumType.STRING)
    private SampleType type = SampleType.DJ;
    private String wt;
    private String sampleNo;

    /**
     * 产品信息
     */
    @OneToOne
    @JoinColumn(referencedColumnName = "productId", name = "product_id")
    private SampleProduct product;

    /**
     * 受检单位
     */
    @OneToOne
    @JoinColumn(referencedColumnName = "enterpriseId", name = "inspected_enterprise_id")
    @Where(clause = "deleted=0")
    private EnterpriseInfo inspectedEnterprise;

    /**
     * 生产单位
     */
    @OneToOne
    @JoinColumn(referencedColumnName = "enterpriseId", name = "product_enterprise_id")
    @Where(clause = "deleted=0")
    private EnterpriseInfo productEnterprise;

    /**
     * 委托单位
     */
    @OneToOne
    @JoinColumn(referencedColumnName = "enterpriseId", name = "delegation_enterprise_id")
    @Where(clause = "deleted=0")
    private EnterpriseInfo delegationEnterprise;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(referencedColumnName = "sampleId", name = "sample_id")
    @Where(clause = "deleted=0")
    private List<CheckProject> checkProjectList = Lists.newArrayList();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "sampleId", name = "sample_id")
    @Where(clause = "deleted=0")
    private List<ProLabel> extraProLabel = Lists.newArrayList();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", name = "feeId")
    @Where(clause = "deleted=0")
    private ZiboFee ziboFee;


    /**
     * 任务来源
     */
    private String taskSource;

    /**
     * 抽样单位
     */
    private String sampleUnit;

    /**
     * 获取报告方式
     */
    private String getReport;


    /**
     * 报告标准
     */
    private String standards;

    /**
     * 检验方法标准
     */
    private String inspectRequire;

    /**
     * 检验结论
     */
    private String inspectResult;

    /**
     * 检验状态
     */
    private String inspectStatus;

    /**
     * 温度
     */
    private String temperature;

    /**
     * 湿度
     */
    private String humidity;

    /**
     * 气压
     */
    private String pressure;

    /**
     * 检验起始日期
     */
    private String fromDate;

    /**
     * 检验结束日期
     */
    private String toDate;

    /**
     * 检验方法标准
     */
    private String inspectStandard;

    /**
     * 备注
     */
    private String remark;

    /**
     * 批准人
     */
    private String approver;
    private Long approverId;

    /**
     * 审核人
     */
    private String auditor;
    private Long auditorId;

    /**
     * 主检人
     */
    private String mainInspector;
    private Long mainInspectorId;

    private Boolean rework = false;
}
