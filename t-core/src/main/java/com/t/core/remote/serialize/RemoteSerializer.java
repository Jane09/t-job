package com.t.core.remote.serialize;

import com.t.core.constant.ExtConfig;
import com.t.core.spi.SPI;

/**
 * @author tb
 * @date 2018/12/18 14:44
 */
@SPI(key = ExtConfig.REMOTING_SERIALIZABLE_DFT, dftValue = "fastjson")
public interface RemoteSerializer {
    /**
     * 获取序列化ID
     * @return 返回序列号
     */
    int getId();

    /**
     * 序列化
     * @param obj
     * @return
     * @throws Exception
     */
    byte[] serialize(final Object obj) throws Exception;

    /**
     * 反序列化
     * @param data
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T deserialize(final byte[] data, Class<T> clazz) throws Exception;
}
