package com.t.core.remote.exception;

/**
 * @author tb
 * @date 2018/12/18 15:01
 */
public class RemoteSendRequestException extends RemoteException {

    public RemoteSendRequestException(String message) {
        super(message);
    }

    public RemoteSendRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
