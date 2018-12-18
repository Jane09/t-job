package com.t.core.remote.exception;

/**
 * @author tb
 * @date 2018/12/18 15:02
 */
public class RemoteTimeoutException extends RemoteException {
    public RemoteTimeoutException(String message) {
        super(message);
    }

    public RemoteTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }
}
