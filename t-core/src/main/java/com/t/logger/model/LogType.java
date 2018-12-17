package com.t.logger.model;

public enum LogType {
    // 接受任务
    RECEIVE,
    // 任务发送 开始执行
    SENT,
    // 任务执行完成
    FINISHED,
    // TaskTracker 重新发送的任务执行结果
    RESEND,
    // 修复死掉的任务
    FIXED_DEAD,
    // 业务日志
    BIZ,
    // 更新
    UPDATE,
    // 删除
    DEL,
    // 暂停
    SUSPEND,
    // 恢复
    RESUME,
    ;
}
