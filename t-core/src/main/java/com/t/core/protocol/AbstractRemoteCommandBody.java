package com.t.core.protocol;

import com.t.core.annotation.NotNull;
import com.t.core.annotation.Nullable;
import com.t.core.commons.utils.SystemClock;
import com.t.core.remote.exception.RemoteCommandFieldCheckException;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tb
 * @date 2018/12/18 14:01
 */
@Getter
@Setter
public abstract class AbstractRemoteCommandBody implements RemoteCommandBody {
    /**
     * 节点组 当前节点的 group(统一类型, 具有相同功能的节点group相同)
     */
    @NotNull
    private String nodeGroup;

    /**
     * NodeType 的字符串表示, 节点类型
     */
    @NotNull
    private String nodeType;
    /**
     * 当前节点的唯一标识
     */
    @NotNull
    private String identity;

    private Long timestamp = SystemClock.now();

    // 额外的参数
    @Nullable
    private Map<String, Object> extParams;

    public void putExtParam(String key, Object obj) {
        if (this.extParams == null) {
            this.extParams = new HashMap<>(16);
        }
        this.extParams.put(key, obj);
    }

    @Override
    public void checkFields() throws RemoteCommandFieldCheckException {

    }
}
