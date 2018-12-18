package com.t.core.remote.serialize;

import com.alibaba.fastjson.JSON;

import java.nio.charset.StandardCharsets;

/**
 * @author tb
 * @date 2018/12/18 14:48
 */
public class FastJsonSerializer implements RemoteSerializer {

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public byte[] serialize(Object obj) {
        String json = toJson(obj);
        return json.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        final String json = new String(data, StandardCharsets.UTF_8);
        return fromJson(json, clazz);
    }

    private String toJson(final Object obj) {
        return JSON.toJSONString(obj, false);
    }

    private <T> T fromJson(String json, Class<T> classOfT) {
        return JSON.parseObject(json, classOfT);
    }
}
