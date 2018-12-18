package com.t.core.remote.serialize;

/**
 * @author tb
 * @date 2018/12/18 14:50
 */
@SuppressWarnings("unchecked")
public class AdaptiveSerializer implements RemoteSerializer {

//    private static final Map<Integer, RemoteSerializer>
//            ID_SERIALIZABLE_MAP = new HashMap(){{
//        Set<String> names = ServiceLoader.getServiceProviders(RemoteSerializer.class);
//        for (String name : names) {
//            if (!Constants.ADAPTIVE.equalsIgnoreCase(name)) {
//                RemoteSerializer serializable = ServiceLoader.load(RemoteSerializer.class, name);
//                ID_SERIALIZABLE_MAP.put(serializable.getId(), serializable);
//            }
//        }
//    }};

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public byte[] serialize(Object obj) throws Exception {
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        return null;
    }
}
