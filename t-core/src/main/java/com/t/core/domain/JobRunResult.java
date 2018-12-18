package com.t.core.domain;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author tb
 * @date 2018/12/18 14:30
 */
@Getter
@Setter
public class JobRunResult implements Serializable {

    private JobMeta jobMeta;

    private Action action;

    private String msg;
    // 任务完成时间
    private Long time;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
