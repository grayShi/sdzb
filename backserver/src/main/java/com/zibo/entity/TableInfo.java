package com.zibo.entity;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

/**
 * @author shaoxiong.zhan
 */
@Entity
@Data
@Where(clause = "deleted=0")
public class TableInfo extends IEntity {
    private String bindData;
    private Integer h;
    private Integer i;
    private String message;
    private Boolean moved = false;
    private Integer w;
    private Integer x;
    private Integer y;
    private String position;
    @ElementCollection
    private List<String> border;
    private String fontSize;
}
