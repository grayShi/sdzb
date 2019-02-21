package com.zibo.constants;

/**
 * @author shaoxiong.zhan
 */

public enum SampleStatus {
    initial("已登记"),
    rework("返工"),
    pre_test("未校验"),
    pre_check("未较核"),
    pre_approve("未批准"),
    pre_print("未打印"),
    registered("已登记"),
    fetched("已领取");
    private String status;

    SampleStatus(String s) {
        this.status = s;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
