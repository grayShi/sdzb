package com.zibo.entity;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 样品单号
 * @author shaoxiong.zhan
 */
@Entity
@Data
@Where(clause = "deleted=0")
public class SampleOrder extends IEntity {
    @Column(unique = true, nullable = false)
    private String sampleName;

    @Column(unique = true, nullable = false)
    private String sampleNo;

    private String remark;
}
