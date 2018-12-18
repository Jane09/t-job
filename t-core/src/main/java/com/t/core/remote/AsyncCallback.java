package com.t.core.remote;

/**
 * @author tb
 * @date 2018/12/18 15:07
 */
public interface AsyncCallback {

    void operateComplete(ResponseFuture future);
}
