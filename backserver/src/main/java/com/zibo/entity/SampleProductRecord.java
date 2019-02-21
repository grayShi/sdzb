package com.zibo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 领样，入库和退样记录
 */
@Data
@Entity
public class SampleProductRecord extends IEntity {
    private String sampleProductId;
    private String opDate;
    private String opUser;
    private String opPlace;
    private Integer opCount;
    @Enumerated(EnumType.STRING)
    private OpType opType = OpType.get;

    public enum OpType {
        //实验室领取化验
        get,
        //拿走，不还
        take,
        //退样
        withdraw,
        //入库
        in_store
    }
}
