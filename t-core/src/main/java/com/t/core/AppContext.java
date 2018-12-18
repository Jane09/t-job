package com.t.core;

import com.t.core.cluster.Config;
import com.t.core.protocol.CommandBodyWrapper;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tb
 * @date 2018/12/17 14:22
 */
@Getter
@Setter
public abstract class AppContext {

    // 节点配置信息
    private Config config;
    // 节点管理
//    private SubscribedNodeManager subscribedNodeManager;
    // master节点选举者
//    private MasterElector masterElector;
    // 节点通信CommandBody包装器
    private CommandBodyWrapper commandBodyWrapper;
    // 事件中心
//    private EventCenter eventCenter;
    // 监控中心
//    private MStatReporter mStatReporter;
    // 注册中心状态监控
//    private RegistryStatMonitor registryStatMonitor;
    // 命令中心
//    private HttpCmdServer httpCmdServer;
}
