package com.t.core.protocol;

import com.t.core.domain.Job;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author tb
 * @date 2018/12/18 14:38
 */
@Getter
@Setter
public class JobSubmitResponse extends AbstractRemoteCommandBody {

    private Boolean success = true;

    private String msg;

    // 失败的jobs
    private List<Job> failedJobs;
}
