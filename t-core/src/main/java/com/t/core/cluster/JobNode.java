package com.t.core.cluster;

public interface JobNode {

    /**
     * 启动节点
     */
    void start();

    /**
     * 停止节点
     */
    void stop();

    /**
     * destroy
     */
    void destroy();
}
