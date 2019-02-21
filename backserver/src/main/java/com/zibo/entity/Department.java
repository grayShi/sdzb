package com.zibo.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author shaoxiong.zhan
 */
@Entity
@Data
@Where(clause = "deleted=0")
public class Department extends IEntity {
    private String deptName;
    /**
     * 部门简称
     */
    private String deptAbbr;

    /**
     * 检验单位
     */
    private String checkUnit;

    /**
     * 日期
     */
    private String date;

    /**
     * 状态
     */
    @Enumerated(EnumType.STRING)
    private DeptStatus status = DeptStatus.in_use;

    @Type(type = "text")
    private String remarks;

    public enum DeptStatus {
        /**
         * 启用
         */
        in_use,

        /**
         * 废弃
         */
        discard
    }
}
