package com.t.core.remote;

import java.net.SocketAddress;

/**
 * @author tb
 * @date 2018/12/18 15:10
 */
public interface Channel {

    SocketAddress localAddress();

    SocketAddress remoteAddress();

    ChannelHandler writeAndFlush(Object msg);

    ChannelHandler close();

    boolean isConnected();

    boolean isOpen();

    boolean isClosed();
}
