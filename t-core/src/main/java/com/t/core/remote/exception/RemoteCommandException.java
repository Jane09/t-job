package com.t.core.remote.exception;

/**
 * @author tb
 * @date 2018/12/18 15:21
 */
public class RemoteCommandException extends RemoteException {
    public RemoteCommandException(String message) {
        super(message);
    }

    public RemoteCommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
