package com.t.core.protocol;

import com.t.core.annotation.NotNull;
import com.t.core.domain.JobMeta;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author tb
 * @date 2018/12/18 14:37
 */
@Getter
@Setter
public class JobPushRequest extends AbstractRemoteCommandBody {

    @NotNull
    private List<JobMeta> jobMetaList;
}
