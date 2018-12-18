package com.t.core.remote;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tb
 * @date 2018/12/18 16:54
 */
@Slf4j
public abstract class AbstractServiceThread implements Runnable {

    // 线程回收时间，默认90S
    private static final long JOIN_TIME = 90 * 1000;
    // 是否已经被Notify过
    protected volatile boolean hasNotified = false;
    // 线程是否已经停止
    protected volatile boolean stopped = false;

    // 执行线程
    protected final Thread thread;

    public AbstractServiceThread() {
        this.thread = new Thread(this, this.getServiceName());
    }

    public abstract String getServiceName();


    public void start() {
        this.thread.start();
    }

    public void shutdown() {
        this.shutdown(false);
    }

    public void stop() {
        this.stop(false);
    }


    public void makeStop() {
        this.stopped = true;
        log.info("makestop thread " + this.getServiceName());
    }

    public void stop(final boolean interrupt) {
        this.stopped = true;
        log.info("stop thread " + this.getServiceName() + " interrupt " + interrupt);
        synchronized (this) {
            if (!this.hasNotified) {
                this.hasNotified = true;
                this.notify();
            }
        }

        if (interrupt) {
            this.thread.interrupt();
        }
    }

    public void shutdown(final boolean interrupt) {
        this.stopped = true;
        if (log.isDebugEnabled()) {
            log.debug("shutdown thread " + this.getServiceName() + " interrupt " + interrupt);
        }
        synchronized (this) {
            if (!this.hasNotified) {
                this.hasNotified = true;
                this.notify();
            }
        }

        try {
            if (interrupt) {
                this.thread.interrupt();
            }

            long beginTime = System.currentTimeMillis();
            this.thread.join(JOIN_TIME);
            if (log.isDebugEnabled()) {
                long eclipseTime = System.currentTimeMillis() - beginTime;
                log.info("join thread " + this.getServiceName() + " eclipse time(ms) " + eclipseTime + " "
                        + JOIN_TIME);
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void wakeup() {
        synchronized (this) {
            if (!this.hasNotified) {
                this.hasNotified = true;
                this.notify();
            }
        }
    }

    protected void waitForRunning(long interval) {
        synchronized (this) {
            if (this.hasNotified) {
                this.hasNotified = false;
                this.onWaitEnd();
                return;
            }

            try {
                this.wait(interval);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            } finally {
                this.hasNotified = false;
                this.onWaitEnd();
            }
        }
    }

    protected void onWaitEnd() {
    }

    public boolean isStopped() {
        return stopped;
    }
}
