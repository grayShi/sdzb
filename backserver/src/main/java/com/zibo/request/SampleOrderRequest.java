package com.zibo.request;

import lombok.Data;
import org.springframework.data.domain.Sort;

/**
 * @author shaoxiong.zhan
 */
@Data
public class SampleOrderRequest {
    private Sort.Direction direction = Sort.Direction.ASC;
    private String property;
}
