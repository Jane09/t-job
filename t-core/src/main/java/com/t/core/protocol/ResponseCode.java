package com.t.core.protocol;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tb
 * @date 2018/12/18 14:40
 */
@AllArgsConstructor
@Getter
public enum ResponseCode {

    // 成功
    SUCCESS(0),
    // 发生了未捕获异常
    SYSTEM_ERROR(1),
    // 由于线程池拥堵，系统繁忙
    SYSTEM_BUSY(2),
    // 请求代码不支持
    REQUEST_CODE_NOT_SUPPORTED(3),
    // 请求参数错误
    REQUEST_PARAM_ERROR(4),

    // 任务执行中
    JOB_IN_PROGRESS(10),
    // 接受任务成功
    JOB_RECEIVE_SUCCESS(11),
    // 接收任务失败
    JOB_RECEIVE_FAILED(12),
    // 任务执行失败
    JOB_RUN_FAILURE(13),
    // 没有任务节点执行
    NO_TASK_TRACKER(15),
    // 心跳成功
    HEART_BEAT_SUCCESS(16),
    // 没有节点分组
    NO_NODE_GROUP(17),
    // 没有可用的 任务执行
    NO_AVAILABLE_JOB_RUNNER(18),
    // 任务推送成功
    JOB_PUSH_SUCCESS(19),
    // 任务处理成功
    JOB_NOTIFY_SUCCESS(20),
    // 任务推送
    JOB_PULL_SUCCESS(21),
    // 业务日志发送成功
    BIZ_LOG_SEND_SUCCESS(22),
    // 任务删除成功
    JOB_CANCEL_SUCCESS(23),
    // 任务删除失败
    JOB_CANCEL_FAILED(24),
    // 任务执行错误
    JOB_RUN_ERROR(25),
    ;
    private int code;

    public static ResponseCode valueOf(int code) {
        for (ResponseCode responseCode : ResponseCode.values()) {
            if (responseCode.code == code) {
                return responseCode;
            }
        }
        throw new IllegalArgumentException("can't find the response code !");
    }
}
