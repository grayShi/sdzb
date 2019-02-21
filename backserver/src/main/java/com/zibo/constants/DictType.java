package com.zibo.constants;

public enum DictType {
    dept("部门"),
    sample_type("样品类型"),
    examine_type("检验类型"),
    store_place("备样存放地点"),
    sample_number("样品单号"),
    sample_level("样品等级"),
    sample_method("抽样方式"),
    sample_place("抽样地点"),
    check_type("检验类型"),
    sample_store_place("样品存放地点");
    private String content;

    DictType(String s) {
        this.content = s;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
