package com.t.core.spi;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author tb
 * @date 2018/12/18 10:12
 */
public final class ClassLoaderUtils {


    private static class ConstructorCache {

        private final ConcurrentMap<ClassLoader, ConcurrentMap<String, WeakReference<Constructor>>> cache;

        private ConstructorCache() {
            this.cache = new ConcurrentHashMap<>();
        }

        private <T> void put(ClassLoader classLoader, String className, Constructor<T> constructor) {
            ClassLoader cl = null == classLoader?ClassLoaderUtils.class.getClassLoader() : classLoader;
            ConcurrentMap<String,WeakReference<Constructor>> innerCache = cache.get(cl);
            if(null == innerCache) {
                innerCache = new ConcurrentHashMap<>(100);
                ConcurrentMap<String,WeakReference<Constructor>> old = cache.putIfAbsent(cl,innerCache);
                if(null != old){
                    innerCache = old;
                }
            }
            innerCache.put(className,new WeakReference<>(constructor));
        }
    }
}
