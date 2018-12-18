package com.t.core.protocol;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author tb
 * @date 2018/12/18 14:37
 */
@Getter
@Setter
public class JobPushResponse extends AbstractRemoteCommandBody {
    private List<String> failedJobIds;
}
