package com.zibo.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 返工记录
 *
 * @author shaoxiong.zhan
 */
@Data
@Entity
@Where(clause = "deleted=0")
public class ReWorkLog extends IEntity {
    @ManyToOne
    @JoinColumn(referencedColumnName = "sampleId", name = "sample_id")
    private SampleData sampleData;
    private String reasons;
    @Type(type = "text")
    private String remarks;
    /**
     * 被返工人
     */
    private String reworker = "gao";
    private Long reworkerId = 0L;

    private String operator = "gao";
    private Long operatorId = 0L;
}
