package com.t.core.protocol;

import com.t.core.AppContext;
import com.t.core.cluster.Config;
import lombok.RequiredArgsConstructor;

/**
 * @author tb
 * @date 2018/12/18 14:19
 */
@RequiredArgsConstructor
public class CommandBodyWrapper {
    private final Config config;

    public <T extends AbstractRemoteCommandBody> T wrapper(T commandBody) {
        commandBody.setNodeGroup(config.getNodeGroup());
        commandBody.setNodeType(config.getNodeType().name());
        commandBody.setIdentity(config.getIdentity());
        return commandBody;
    }

    public static <T extends AbstractRemoteCommandBody> T wrapper(AppContext appContext, T commandBody) {
        return appContext.getCommandBodyWrapper().wrapper(commandBody);
    }
}
