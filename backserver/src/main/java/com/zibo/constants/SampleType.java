package com.zibo.constants;

/**
 * 样品类型
 */
public enum SampleType {
    WT("委托"), DJ("定检"), G("国抽"), SHENG("省"), SHI("市"), TJ("统计"), GS("工商"), ZX("专项"), FX("风险");
    private String type;

    SampleType(String t) {
        this.type = t;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
