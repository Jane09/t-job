package com.t.core.remote;

/**
 * @author tb
 * @date 2018/12/18 16:47
 */
public interface ChannelEventListener {

    void onChannelConnect(final String remoteAddr, final Channel channel);

    void onChannelClose(final String remoteAddr, final Channel channel);

    void onChannelException(final String remoteAddr, final Channel channel);

    void onChannelIdle(IdleState idleState, final String remoteAddr, final Channel channel);
}
