package com.t.core.protocol;

import com.t.core.domain.BizLog;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author tb
 * @date 2018/12/18 14:15
 */
@Getter
@Setter
public class BizLogSendRequest extends AbstractRemoteCommandBody {

    private List<BizLog> bizLogs;
}
