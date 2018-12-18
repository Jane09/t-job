package com.t.core.commons.utils;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author tb
 * @date 2018/12/18 14:05
 */
public final class SystemClock {

    public static void main(String[] args) {
//        while (true) {
//            System.out.println(SystemClock.now());
//        }
    }
    private final long period;
    private final AtomicLong now;

    private SystemClock(long period) {
        this.period = period;
        now = new AtomicLong(System.currentTimeMillis());
        scheduleClockUpdating();
    }

    private static class InstanceHolder {
        static final SystemClock INSTANCE = new SystemClock(1);
    }

    private static SystemClock instance() {
        return InstanceHolder.INSTANCE;
    }

    private void scheduleClockUpdating() {
        ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.Builder().namingPattern("system-clock").build(),
                new ThreadPoolExecutor.AbortPolicy());
        scheduler.scheduleAtFixedRate(() -> now.set(System.currentTimeMillis()), period, period, TimeUnit.MILLISECONDS);
    }

    private long currentTimeMillis() {
        return now.get();
    }

    public static long now() {
        return instance().currentTimeMillis();
    }
}
