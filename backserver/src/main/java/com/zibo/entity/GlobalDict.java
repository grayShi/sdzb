package com.zibo.entity;

import com.zibo.constants.DictType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author shaoxiong.zhan
 */
@Data
@Entity
public class GlobalDict extends IEntity {
    @Enumerated(EnumType.STRING)
    private DictType type;
    private String dict;
    private String detail;
    /*
    可能是嵌套结构
     */
    private Long parentId;
}
