package com.t.client.domain;

import com.t.core.domain.Job;

import java.util.List;

/**
 * @author tb
 * @date 2018/12/18 9:54
 */
public class Response {

    private boolean success;
    private String msg;
    private String code;

    // 如果success 为false, 这个才会有值
    private List<Job> failedJobs;
}
