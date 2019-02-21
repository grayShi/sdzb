package com.zibo.request;

import com.google.common.collect.Lists;
import com.zibo.entity.CheckProject;
import com.zibo.entity.EnterpriseInfo;
import com.zibo.entity.IEntity;
import com.zibo.entity.ProLabel;
import com.zibo.entity.SampleData;
import com.zibo.utils.EntityUtils;
import lombok.Data;

import java.util.List;

/**
 * @author shaoxiong.zhan
 */
@Data
public class SampleModel extends IEntity {
    private String specialSymbol;
    private Long deptId;
    private String department;
    private String sampleNo;
    private String wt;
    private String sampleName;
    private String checkType;
    private String unitName;
    private String reportNo;
    private String mark;
    private String produceNo;
    private String sampleLevel;
    private String size;
    private String proDate;
    private List<String> proStandard;
    private String checkPro;
    private Integer sampleCount;
    private String savePlace;
    private String samplePlace;
    private Integer countNo;
    private String handleType;
    private String sampleStatus;
    private String status;
    private String completeDate;
    private Integer number;
    private String mode;
    private String samplingPlace;
    private String samplingWay;
    private String samDate;
    private String samPeople;
    private Integer samBase;
    private String comPeople;
    private String sendPeople;
    private String reachTime;
    private String sealPeople;
    private String sealState;
    /**
     * 主键 enterpriseId
     */
    private String inspectEnterpriseId;
    private String inspectCompany;
    private String inspectComCode;
    private String inspectComAddress;
    private String inspectComPostNo;
    private String inspectComPhone;
    private String inspectComContact;

    /**
     * 主键 enterpriseId
     */
    private String productEnterpriseId;
    private String produceCompany;
    private String produceComCode;
    private String produceComAddress;
    private String produceComPostNo;
    private String produceComPhone;
    private String produceComContact;

    /**
     * 主键 enterpriseId
     */
    private String deputeEnterpriseId;
    private String deputeCompany;
    private String deputeComCode;
    private String deputeComAddress;
    private String deputeComPostNo;
    private String deputeComPhone;
    private String deputeComContact;
    private String taskSource;
    private String sampleUnit;
    private String getReport;


    /**
     * 2019-01-01 补充字段
     */

    /**
     * 报告标准
     */
    private String[] standard;

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

    List<CheckProject> checkProjectList = Lists.newArrayList();
    private List<ProLabel> extraProLabel = Lists.newArrayList();

    private Boolean rework;

    public SampleModel() {

    }

    public SampleModel(SampleData sampleData) {
        if (sampleData.getProduct() != null) {
            EntityUtils.copyProperties(sampleData.getProduct(), this);
        }
        EntityUtils.copyProperties(sampleData, this);
        if (sampleData.getStandards() != null) {
            this.setStandard(sampleData.getStandards().split(","));
        }
        this.setStatus(sampleData.getSampleStatus().getStatus());
        this.setInspectEnterprise(sampleData.getInspectedEnterprise());
        this.setProductEnterprise(sampleData.getProductEnterprise());
        this.setDelegateEnterprise(sampleData.getDelegationEnterprise());
    }

    public void setInspectEnterprise(EnterpriseInfo enterprise) {
        this.setInspectCompany(enterprise.getEnterpriseName());
        this.setInspectComAddress(enterprise.getEnterpriseAddress());
        this.setInspectComCode(enterprise.getEnterpriseCode());
        this.setInspectComContact(enterprise.getLinkedUser());
        this.setInspectComPhone(enterprise.getPhone());
        this.setInspectComPostNo(enterprise.getPostcode());
    }

    public void setProductEnterprise(EnterpriseInfo enterprise) {
        this.setProduceCompany(enterprise.getEnterpriseName());
        this.setProduceComAddress(enterprise.getEnterpriseAddress());
        this.setProduceComCode(enterprise.getEnterpriseCode());
        this.setProduceComContact(enterprise.getLinkedUser());
        this.setProduceComPhone(enterprise.getPhone());
        this.setProduceComPostNo(enterprise.getPostcode());
    }

    public void setDelegateEnterprise(EnterpriseInfo enterprise) {
        this.setDeputeCompany(enterprise.getEnterpriseName());
        this.setDeputeComAddress(enterprise.getEnterpriseAddress());
        this.setDeputeComCode(enterprise.getEnterpriseCode());
        this.setDeputeComContact(enterprise.getLinkedUser());
        this.setDeputeComPhone(enterprise.getPhone());
        this.setDeputeComPostNo(enterprise.getPostcode());
    }
}
