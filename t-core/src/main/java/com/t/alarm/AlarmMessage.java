package com.t.alarm;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tb
 * @date 2018/12/17 14:35
 */
@Getter
@Setter
public class AlarmMessage {

    private long time;

    private AlarmType type;

    private String msg;
}
