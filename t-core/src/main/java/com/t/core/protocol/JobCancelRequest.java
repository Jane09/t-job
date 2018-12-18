package com.t.core.protocol;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tb
 * @date 2018/12/18 14:28
 */
@Getter
@Setter
public class JobCancelRequest extends AbstractRemoteCommandBody {

    private String taskId;

    private String taskTrackerNodeGroup;
}
