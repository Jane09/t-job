package com.t.core.protocol;

import com.t.core.annotation.NotNull;
import com.t.core.domain.JobRunResult;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tb
 * @date 2018/12/18 14:29
 */
@Getter
@Setter
public class JobCompletedRequest extends AbstractRemoteCommandBody {

    /**
     * 是否接受新任务
     */
    private boolean receiveNewJob = false;

    @NotNull
    private List<JobRunResult> jobRunResults;

    // 是否是重发(重发是批量发)
    private boolean reSend = false;

    public void addJobResult(JobRunResult jobRunResult) {
        if (jobRunResults == null) {
            jobRunResults = new ArrayList<>();
        }
        jobRunResults.add(jobRunResult);
    }
}
