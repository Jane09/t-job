package com.t.core.remote;

import com.t.core.protocol.RemoteCommand;
import com.t.core.remote.exception.*;

public interface RemoteClient {

    /**
     * 启动
     */
    void start() throws RemoteException;

    /**
     * 关闭
     */
    void shutdown();


    RemoteCommand invokeSync(final String addr, final RemoteCommand request,final long timeoutMs)
            throws InterruptedException, RemoteConnectException, RemoteSendRequestException, RemoteTimeoutException;

    /**
     * 异步调用
     */
    void invokeAsync(final String addr, final RemoteCommand request,final long timeoutMs,AsyncCallback callback)
            throws InterruptedException, RemoteConnectException, RemoteSendRequestException, RemoteTimeoutException, RemoteTooMuchRequestException;

    /**
     * 单向调用
     */
    void invokeOneway(final String addr, final RemoteCommand request,final long timeoutMs)
            throws InterruptedException, RemoteConnectException, RemoteSendRequestException, RemoteTimeoutException, RemoteTooMuchRequestException;
}
