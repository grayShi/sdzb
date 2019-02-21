package com.zibo.request;

import com.zibo.constants.SampleStatus;
import lombok.Data;

/**
 * @author shaoxiong.zhan
 */
@Data
public class SampleBatchOperation {
    private Long[] id;
    private Long[] sampleIds;
    private SampleStatus status = SampleStatus.initial;
}
