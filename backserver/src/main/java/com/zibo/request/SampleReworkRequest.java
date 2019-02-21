package com.zibo.request;

import com.zibo.constants.SampleStatus;
import lombok.Data;

/**
 * @author shaoxiong.zhan
 */
@Data
public class SampleReworkRequest {
    private String[] reason;
    private String remarks;
    private SampleStatus status = SampleStatus.initial;
}
