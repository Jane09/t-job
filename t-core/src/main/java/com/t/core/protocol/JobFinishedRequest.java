package com.t.core.protocol;

import com.t.core.annotation.NotNull;
import com.t.core.domain.JobResult;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tb
 * @date 2018/12/18 14:34
 */
@Getter
@Setter
public class JobFinishedRequest extends AbstractRemoteCommandBody {

    /**
     * 是否接受新任务
     */
    private boolean receiveNewJob = false;

    @NotNull
    private List<JobResult> jobResults;

    // 是否是重发(重发是批量发)
    private boolean reSend = false;


    public void addJobResult(JobResult jobResult) {
        if (jobResults == null) {
            jobResults = new ArrayList<>();
        }
        jobResults.add(jobResult);
    }

    public void addJobResults(List<JobResult> jobResults) {
        if (this.jobResults == null) {
            this.jobResults = new ArrayList<>();
        }
        this.jobResults.addAll(jobResults);
    }
}
