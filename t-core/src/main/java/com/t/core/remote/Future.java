package com.t.core.remote;

/**
 * @author tb
 * @date 2018/12/18 15:12
 */
public interface Future {
    boolean isSuccess();

    Throwable cause();
}
