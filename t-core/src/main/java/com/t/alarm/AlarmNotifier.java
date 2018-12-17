package com.t.alarm;

/**
 * @author tb
 * @date 2018/12/17 14:35
 */
public interface AlarmNotifier<T extends AlarmMessage> {

    /**
     * 告警通知
     * @param message
     */
    void notify(T message);
}
