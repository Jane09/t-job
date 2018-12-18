package com.t.core.protocol;

import com.t.core.annotation.NotNull;
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
public class JobSubmitRequest extends AbstractRemoteCommandBody {

    @NotNull
    private List<Job> jobs;

}
