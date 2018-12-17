package com.t.core.cluster;

import org.apache.commons.lang3.StringUtils;

public enum NodeType {

    // job tracker
    JOB_TRACKER,
    // task tracker
    TASK_TRACKER,
    // client
    JOB_CLIENT,
    // monitor
    MONITOR,

    BACKEND;

    public static NodeType convert(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return NodeType.valueOf(value);
    }
}
