package com.t.core.remote;

import com.t.core.protocol.RemoteCommand;
import com.t.core.remote.exception.RemoteCommandException;

/**
 * @author tb
 * @date 2018/12/18 15:20
 */
public interface RemoteProcessor {

    /**
     * 处理命令
     */
    RemoteCommand process(Channel channel, RemoteCommand request) throws RemoteCommandException;
}
