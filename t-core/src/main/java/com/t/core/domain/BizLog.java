package com.t.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author tb
 * @date 2018/12/18 14:13
 */
@Getter
@Setter
public class BizLog implements Serializable {

    private String taskId;
    private JobType jobType;
    private String jobId;
    private String realTaskId;
    private String msg;
    private Level level;
    private Long logTime;
    private String taskTrackerIdentity;
    private String taskTrackerNodeGroup;
}
