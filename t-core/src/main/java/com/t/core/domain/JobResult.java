package com.t.core.domain;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author tb
 * @date 2018/12/18 14:35
 */
@Getter
@Setter
public class JobResult implements Serializable {

    private Job job;

    // 执行成功还是失败
    private boolean success;

    private String msg;
    // 任务完成时间
    private Long time;
    /**
     * 执行的时序 (每个执行周期都不一样，但是修复死任务，重试等不会改变)
     */
    private String exeSeqId;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
