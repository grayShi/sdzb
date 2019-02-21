package com.zibo.request;

import lombok.Data;

@Data
public class SampleProductInStoreRequest {
    private String inStorePlace;
    private Integer inStoreCount;
}
