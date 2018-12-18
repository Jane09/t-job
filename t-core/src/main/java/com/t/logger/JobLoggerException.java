package com.t.logger;

/**
 * @author tb
 * @date 2018/12/17 14:54
 */
public class JobLoggerException extends RuntimeException {

    public JobLoggerException() {
        super();
    }

    public JobLoggerException(String message) {
        super(message);
    }

    public JobLoggerException(String message, Throwable cause) {
        super(message, cause);
    }
}
