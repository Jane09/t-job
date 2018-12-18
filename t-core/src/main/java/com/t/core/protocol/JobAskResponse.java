package com.t.core.protocol;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author tb
 * @date 2018/12/18 14:27
 */
@Getter
@Setter
public class JobAskResponse extends AbstractRemoteCommandBody {

    /**
     * 返回不在执行中的jobIds(死掉的)
     */
    private List<String> jobIds;
}
