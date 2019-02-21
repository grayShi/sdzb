package com.zibo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zibo.security.JPACryptoConverter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

/**
 * @author shaoxiong.zhan
 */
@Entity
@Data
public class Account extends IEntity {
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String phoneNumber;
    private String displayName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Convert(converter = JPACryptoConverter.class)
    private String password;

    /**
     * 工号
     */
    private String no;

    /**
     * 部门
     */
    private String department;

    /**
     * 部门ID
     */
    private Long deptId;

    private String avatar;

    @JsonIgnore
    public String getAuthority() {
        return "ROLE_ACCOUNT";
    }
}
