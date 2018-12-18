package com.t.core.protocol;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tb
 * @date 2018/12/18 14:36
 */
@Getter
@Setter
public class JobPullRequest extends AbstractRemoteCommandBody {

    private Integer availableThreads;
}
