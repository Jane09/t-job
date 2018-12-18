package com.t.core.remote.exception;

/**
 * @author tb
 * @date 2018/12/18 13:52
 */
public class RemoteCommandFieldCheckException extends Exception {

    public RemoteCommandFieldCheckException(String message) {
        super(message);
    }

    public RemoteCommandFieldCheckException(String message, Throwable cause) {
        super(message, cause);
    }
}
