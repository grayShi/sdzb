package com.zibo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author shaoxiong.zhan
 */
@Getter
@Setter
@MappedSuperclass
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "deleted", type = "boolean"))
public class IEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected boolean deleted = false;
    @CreationTimestamp
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected Timestamp createTime;
    @UpdateTimestamp
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected Timestamp updateTime;
}
