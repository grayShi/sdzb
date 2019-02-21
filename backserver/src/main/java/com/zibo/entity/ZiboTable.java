package com.zibo.entity;

import com.google.common.collect.Lists;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author shaoxiong.zhan
 */
@Entity
@Data
@Where(clause = "deleted=0")
public class ZiboTable extends IEntity {
    private String tableName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    @Where(clause = "deleted=0")
    private List<TableInfo> tableList = Lists.newArrayList();
}
