package com.t.core.registry;

import com.t.core.cluster.Node;
import com.t.core.cluster.NodeType;

/**
 *
 * <p/>
 *  /LTS/{集群名字}/NODES/TASK_TRACKER/TASK_TRACKER:\\192.168.0.150:8888?group=TASK_TRACKER&threads=8&identity=85750db6-e854-4eb3-a595-9227a5f2c8f6&createTime=1408189898185&isAvailable=true&listenNodeTypes=CLIENT,TASK_TRACKER
 *  /LTS/{集群名字}/NODES/JOB_CLIENT/JOB_CLIENT:\\192.168.0.150:8888?group=JOB_CLIENT&threads=8&identity=85750db6-e854-4eb3-a595-9227a5f2c8f6&createTime=1408189898185&isAvailable=true&listenNodeTypes=CLIENT,TASK_TRACKER
 *  /LTS/{集群名字}/NODES/JOB_TRACKER/JOB_TRACKER:\\192.168.0.150:8888?group=JOB_TRACKER&threads=8&identity=85750db6-e854-4eb3-a595-9227a5f2c8f6&createTime=1408189898185&isAvailable=true&listenNodeTypes=CLIENT,TASK_TRACKER
 *  /LTS/{集群名字}/NODES/MONITOR/MONITOR:\\192.168.0.150:8888?group=JOB_TRACKER&threads=8&identity=85750db6-e854-4eb3-a595-9227a5f2c8f6&createTime=1408189898185&isAvailable=true
 * <p/>
 *
 * @author tb
 * @date 2018/12/18 10:00
 */
public final class NodeRegistryUtils {

    private static final String ROOT = "/tybest/";
    private static final String NODES = "/NODES";

    public static String getRootPath(String clusterName) {
        return ROOT + clusterName + NODES;
    }

    public static String getNodeTypePath(String clusterName, NodeType nodeType) {
        return NodeRegistryUtils.getRootPath(clusterName) + "/" + nodeType;
    }

    public static String getFullPath(Node node) {
        StringBuilder path = new StringBuilder();
        path.append(getRootPath(node.getClusterName()))
                .append("/")
                .append(node.getNodeType())
                .append("/")
                .append(node.getNodeType())
                .append(":\\\\")
                .append(node.getIp());
        if (node.getPort() != null && node.getPort() != 0) {
            path.append(":").append(node.getPort());
        }
        path.append("?")
                .append("group=")
                .append(node.getGroup())
                .append("&clusterName=")
                .append(node.getClusterName());
        if (node.getThreads() != 0) {
            path.append("&threads=")
                    .append(node.getThreads());
        }

        path.append("&identity=")
                .append(node.getIdentity())
                .append("&createTime=")
                .append(node.getCreateTime())
                .append("&isAvailable=")
                .append(node.isAvailable())
                .append("&hostName=")
                .append(node.getHostName());
        if (node.getHttpCmdPort() != null) {
            path.append("&httpCmdPort=").append(node.getHttpCmdPort());
        }

        return path.toString();
    }
}
