package com.t.core.protocol;

import com.t.core.remote.exception.RemoteCommandFieldCheckException;

/**
 * @author tb
 */
public interface RemoteCommandBody {
    /**
     * 校验命令数据的完整性
     * @throws RemoteCommandFieldCheckException 远程命令异常
     */
    void checkFields() throws RemoteCommandFieldCheckException;
}
