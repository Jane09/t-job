package com.t.core.domain;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * @author tb
 * @date 2018/12/18 9:55
 */
@Getter
@Setter
public class Job implements Serializable {

    @NotNull
    private String taskId;
    /**
     * 优先级 (数值越大 优先级越低)
     */
    private Integer priority = 100;

    // 提交的节点 （可以手动指定）
    private String submitNodeGroup;
    // 执行的节点
    @NotNull
    private String taskTrackerNodeGroup;

    private Map<String, String> extParams;
    // 是否要反馈给客户端
    private boolean needFeedback = false;
    // 该任务最大的重试次数
    private int maxRetryTimes = 0;
    /**
     * 执行表达式 和 quartz 的一样
     * 如果这个为空，表示立即执行的
     */
    private String cronExpression;

    /**
     * 重复次数 (-1 表示无限制重复)
     */
    private int repeatCount = 0;
    /**
     * 重复interval
     */
    private Long repeatInterval;
    /**
     * 任务的最触发发时间
     * 如果设置了 cronExpression， 那么这个字段没用
     */
    private Long triggerTime;
    /**
     * 当任务队列中存在这个任务的时候，是否替换更新
     */
    private boolean replaceOnExist = false;
    /**
     * 是否依赖上一个执行周期(对于周期性任务才起作用)
     */
    private boolean relyOnPrevCycle = true;
}
