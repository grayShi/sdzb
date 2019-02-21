package com.zibo.request;

import com.zibo.entity.ReWorkLog;
import com.zibo.utils.DateUtil;
import com.zibo.utils.EntityUtils;
import lombok.Data;

/**
 * @author shaoxiong.zhan
 */
@Data
public class SampleReworkModel {
    private Long id;
    private String approver;
    private String auditor;
    private String mainInspector;
    /**
     * 被返工人
     */
    private String reworker;
    private String operator;
    private String reasons;
    private String reworkTime;
    private String remarks;

    public SampleReworkModel(ReWorkLog reWorkLog) {
        EntityUtils.copyProperties(reWorkLog.getSampleData(), this);
        EntityUtils.copyProperties(reWorkLog, this);
        this.reworkTime = DateUtil.YYYY_MM_DD_HH_MM_SS.format(reWorkLog.getUpdateTime());
    }
}
