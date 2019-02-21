package com.zibo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.MapKeyColumn;
import java.util.Map;
import java.util.UUID;

/**
 * @author shaoxiong.zhan
 */
@Data
@Entity
public class CheckProject extends IEntity {
    @Column(length = 45)
    private String projectId = UUID.randomUUID().toString();
    private String project;
    private String requirement;
    private String unit;
    private String judgement;
    @ElementCollection
    @MapKeyColumn(length = 60)
    private Map<String, String> extraPro;
}
