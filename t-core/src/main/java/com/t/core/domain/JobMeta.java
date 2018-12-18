package com.t.core.domain;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tb
 * @date 2018/12/18 14:31
 */
@Getter
@Setter
public class JobMeta implements Serializable {

    private Job job;

    private String jobId;
    private Map<String, String> internalExtParams;
    // 已经重试的次数
    private int retryTimes;
    // 已经重复的次数
    private Integer repeatedCount;
    private String realTaskId;
    private JobType jobType;

    public String getInternalExtParam(String key) {
        if (internalExtParams == null) {
            return null;
        }
        return internalExtParams.get(key);
    }

    public void setInternalExtParam(String key, String value) {
        if (internalExtParams == null) {
            internalExtParams = new HashMap<String, String>();
        }
        internalExtParams.put(key, value);
    }
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
