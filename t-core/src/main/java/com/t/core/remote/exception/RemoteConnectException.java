package com.t.core.remote.exception;

/**
 * @author tb
 * @date 2018/12/18 15:01
 */
public class RemoteConnectException extends RemoteException {
    public RemoteConnectException(String message) {
        super(message);
    }

    public RemoteConnectException(String message, Throwable cause) {
        super(message, cause);
    }
}
