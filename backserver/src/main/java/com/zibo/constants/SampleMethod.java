package com.zibo.constants;

public enum SampleMethod {
    CY("抽样"), SY("送样");
    private String method;
    SampleMethod(String m) {
        this.method = m;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
