package com.zibo.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @author shaoxiong.zhan
 */
@Entity
@Data
public class ProLabel extends IEntity {
    private String pro;
    private String label;
    private String type;
}
