package com.t.core.remote.exception;

/**
 * @author tb
 * @date 2018/12/18 15:05
 */
public class RemoteTooMuchRequestException extends RemoteException {
    public RemoteTooMuchRequestException(String message) {
        super(message);
    }

    public RemoteTooMuchRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
