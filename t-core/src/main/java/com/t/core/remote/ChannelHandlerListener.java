package com.t.core.remote;

/**
 * @author tb
 * @date 2018/12/18 15:11
 */
public interface ChannelHandlerListener {

    void operationComplete(Future future) throws Exception;
}
