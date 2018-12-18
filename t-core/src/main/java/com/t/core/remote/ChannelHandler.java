package com.t.core.remote;

/**
 * @author tb
 * @date 2018/12/18 15:11
 */
public interface ChannelHandler {
    ChannelHandler addListener(ChannelHandlerListener listener);
}
