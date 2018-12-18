package com.t.core.remote.exception;

/**
 * @author tb
 * @date 2018/12/18 13:48
 */
public class RemoteException extends Exception {

    public RemoteException(String message) {
        super(message);
    }

    public RemoteException(String message, Throwable cause) {
        super(message, cause);
    }
}
