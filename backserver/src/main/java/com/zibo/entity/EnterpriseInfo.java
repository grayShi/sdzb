package com.zibo.entity;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

/**
 * 企业信息
 *
 * @author shaoxiong.zhan
 */
@Entity
@Data
@Where(clause = "deleted=0")
public class EnterpriseInfo extends IEntity {
    @Column(length = 45, unique = true)
    private String enterpriseId = UUID.randomUUID().toString();
    /**
     * 企业名称
     */
    private String enterpriseName;

    /**
     * 企业地址
     */
    private String enterpriseAddress;

    /**
     * 企业邮编
     */
    private String postcode;

    /**
     * 电话
     */
    private String phone;

    /**
     * 企业代码
     */
    private String enterpriseCode;

    /**
     * 联系人
     */
    private String linkedUser;

    /**
     * 储蓄金
     */
    private Double saving = 0d;

    /**
     * 费率
     */
    private Double rate = 0d;

}
