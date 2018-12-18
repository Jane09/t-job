package com.t.core.cluster;

import com.alibaba.fastjson.JSON;
import com.t.core.domain.Job;
import com.t.core.registry.NodeRegistryUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author tb
 * @date 2018/12/17 14:25
 */
@Getter
@Setter
public class Node {
    // 是否可用
    private boolean available = true;
    private String clusterName;
    private NodeType nodeType;
    private String ip;
    private Integer port = 0;
    private String hostName;
    private String group;
    private Long createTime;
    // 线程个数
    private Integer threads;
    // 唯一标识
    private String identity;
    // 命令端口
    private Integer httpCmdPort;
    // 自己关注的节点类型
    private List<NodeType> listenNodeTypes;
    private String fullString;
    private Job job;


    public void addListenNodeType(NodeType nodeType) {
        if (this.listenNodeTypes == null) {
            this.listenNodeTypes = new ArrayList<>();
        }
        this.listenNodeTypes.add(nodeType);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return Objects.equals(identity, node.identity);

    }

    @Override
    public int hashCode() {
        return identity != null ? identity.hashCode() : 0;
    }

    public String getAddress() {
        return ip + ":" + port;
    }

    public String toFullString() {
        if (fullString == null) {
            fullString = NodeRegistryUtils.getFullPath(this);
        }
        return fullString;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
