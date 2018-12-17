package com.t.admin.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

/**
 * @author tb
 * @date 2018/12/17 14:31
 */
@Getter
@Setter
public class JobQueueReq extends PageReq {

    // ------------ 下面是查询条件值 ---------------
    private String jobId;
    private String jobType;
    private String taskId;
    private String realTaskId;
    private String submitNodeGroup;
    private String taskTrackerNodeGroup;
    private Date startGmtCreated;
    private Date endGmtCreated;
    private Date startGmtModified;
    private Date endGmtModified;

    // ------------ 下面是能update的值 -------------------
    private String cronExpression;

    private Boolean needFeedback;

    private Map<String, String> extParams;

    private Date triggerTime;

    private Integer priority;

    private Integer maxRetryTimes;

    private Integer repeatCount;

    private Long repeatInterval;

    private Boolean relyOnPrevCycle;
}
