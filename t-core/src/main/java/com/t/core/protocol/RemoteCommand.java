package com.t.core.protocol;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tb
 * @date 2018/12/18 13:49
 */
@Getter
@Setter
public class RemoteCommand implements Serializable {

    private static final AtomicInteger REQUEST_ID = new AtomicInteger(0);

    private int code;
    private int subCode;
    private int version = 0;
    private int opaque;
    private int flag = 0;
    private String remark;
    private int sid = -1;
    private transient RemoteCommandBody body;


    private RemoteCommand() {

    }

    public static RemoteCommand createRequestCommand(int code, RemoteCommandBody body) {
        RemoteCommand cmd = new RemoteCommand();
        cmd.setCode(code);
        cmd.setBody(body);
        cmd.setOpaque(REQUEST_ID.getAndIncrement());
        return cmd;
    }

    public static RemoteCommand createResponseCommand(int code, String remark, RemoteCommandBody body) {
        RemoteCommand cmd = new RemoteCommand();
        RemoteCommandHelper.markResponseType(cmd);
        cmd.setCode(code);
        cmd.setRemark(remark);
        cmd.setBody(body);
        cmd.setOpaque(REQUEST_ID.getAndIncrement());
        return cmd;
    }

    public static RemoteCommand createResponseCommand(int code, RemoteCommandBody body) {
        return createResponseCommand(code, null, body);
    }

    public static RemoteCommand createResponseCommand(int code) {
        return createResponseCommand(code, null, null);
    }

    public static RemoteCommand createResponseCommand(int code, String remark) {
        return createResponseCommand(code, remark, null);
    }


    @Override
    public String toString() {
        return "RemotingCommand{" +
                "code=" + code +
                ", subCode=" + subCode +
                ", version=" + version +
                ", opaque=" + opaque +
                ", flag=" + flag +
                ", remark='" + remark + '\'' +
                ", sid='" + sid + '\'' +
                ", body=" + JSON.toJSONString(body) +
                '}';
    }
}
