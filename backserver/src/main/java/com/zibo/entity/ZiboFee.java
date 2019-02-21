package com.zibo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

/**
 * 财务收费
 *
 * @author shaoxiong.zhan
 */
@Entity
@Data
public class ZiboFee extends IEntity {
    private String department;
    private Long departmentId;
    private double count;
    private String feeProject;
    private Long feeProjectId;
    private String feeWay;
    private String ticketNo;
    /*
    yyyy-MM-dd
     */
    private String ticketDate;
    /*
    是否到账
     */
    private boolean whether;
    /*
    编号
     */
    private String number;
    private String feeDepartment;
    private Long feeDepartmentId;
    private String section;
    private Long sectionId;

    @OneToMany
    @JoinColumn(referencedColumnName = "id", name = "feeId")
    @Where(clause = "deleted=0")
    @JsonIgnore
    private List<SampleData> samples;
    /*
    备注
     */
    private String more;
    /*
    是否核实（只有两种状态，可以true/false）
     */
    private boolean audit;

    private Timestamp auditTime;
}
