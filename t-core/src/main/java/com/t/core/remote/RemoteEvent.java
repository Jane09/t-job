package com.t.core.remote;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author tb
 * @date 2018/12/18 17:03
 */
@RequiredArgsConstructor
@Getter
public class RemoteEvent {

    private final RemoteEventType type;
    private final String remoteAddr;
    private final Channel channel;


    @Override
    public String toString() {
        return "RemotingEvent [type=" + type + ", remoteAddr=" + remoteAddr + ", channel=" + channel + "]";
    }
}
