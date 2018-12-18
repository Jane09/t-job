package com.t.client.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResponseCode {

    // 没有找到  JobTracker 节点
    JOB_TRACKER_NOT_FOUND("11"),
    // 提交失败并且写入文件
    SUBMIT_FAILED_AND_SAVE_FOR_LATER("12"),
    // 请求参数检查失败
    REQUEST_FILED_CHECK_ERROR("13"),
    // 提交太块
    SUBMIT_TOO_BUSY_AND_SAVE_FOR_LATER("14"),
    // 系统错误
    SYSTEM_ERROR("15")
    ;

    private String code;


}
