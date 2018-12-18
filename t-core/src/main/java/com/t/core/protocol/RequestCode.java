package com.t.core.protocol;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tb
 * @date 2018/12/18 14:39
 */
@AllArgsConstructor
@Getter
public enum RequestCode {
    // 心跳
    HEART_BEAT(10),
    // 提交任务
    SUBMIT_JOB(11),
    // 询问 任务执行的情况
    ASK_JOB_PROGRESS(12),
    // 分发任务
    PUSH_JOB(13),
    // 任务执行完成
    JOB_COMPLETED(14),
    // 询问任务
    JOB_ASK(15),
    // 请求推送任务
    JOB_PULL(16),
    // TaskTracker的业务日志
    BIZ_LOG_SEND(17),
    // 取消(删除)任务
    CANCEL_JOB(18),
    // 提交依赖任务
    SUBMIT_DEP_JOB_GROUP(19),
    ;
    private int code;

    public static RequestCode valueOf(int code) {
        for (RequestCode requestCode : RequestCode.values()) {
            if (requestCode.code == code) {
                return requestCode;
            }
        }
        throw new IllegalArgumentException("can't find the request code !");
    }
}
