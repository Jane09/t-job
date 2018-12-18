package com.t.core.remote;

import com.t.core.domain.Pair;
import com.t.core.protocol.RemoteCommand;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author tb
 * @date 2018/12/18 14:58
 */
@Slf4j
public abstract class AbstractRemote {

    protected final Semaphore semaphoreOneway;
    protected final Semaphore semaphoreAsync;
    @Getter
    protected final ChannelEventListener channelEventListener;

    protected final Map<Integer, ResponseFuture> responseMap = new ConcurrentHashMap<>(256);
    protected final Map<Integer, Pair<RemoteProcessor, ExecutorService>> processorMap = new HashMap<>(64);
    protected final RemoteEventThread remoteEventThread = new RemoteEventThread();

    protected Pair<RemoteProcessor,ExecutorService> defaultRequestProcessor;

    protected AbstractRemote(final int permitsOneway, final int permitsAsync, ChannelEventListener channelEventListener) {
        this.semaphoreOneway = new Semaphore(permitsOneway,true);
        this.semaphoreAsync = new Semaphore(permitsAsync,true);
        this.channelEventListener = channelEventListener;
    }

    public void putRemoteEvent(final RemoteEvent remoteEvent) {
        this.remoteEventThread.putRemoteEvent(remoteEvent);
    }

    public void processRequestCommand(final Channel channel, final RemoteCommand command) {
        
    }




    class RemoteEventThread extends AbstractServiceThread {
        private final LinkedBlockingQueue<RemoteEvent> eventQueue = new LinkedBlockingQueue<>();
        private final int MaxSize = 10000;

        public void putRemoteEvent(final RemoteEvent event){
            if (this.eventQueue.size() <= MaxSize) {
                this.eventQueue.add(event);
            } else {
                log.warn("event queue size[{}] enough, so drop this event {}", this.eventQueue.size(), event.toString());
            }
        }

        @Override
        public String getServiceName() {
            return RemoteEventThread.class.getSimpleName();
        }

        @Override
        public void run() {
            log.info(this.getServiceName() + " service started");
            final ChannelEventListener listener = AbstractRemote.this.getChannelEventListener();
            while (!this.isStopped()) {
                try {
                    RemoteEvent event = this.eventQueue.poll(3000, TimeUnit.MILLISECONDS);
                    if (event != null) {
                        switch (event.getType()) {
                            case ALL_IDLE:
                                listener.onChannelIdle(IdleState.ALL_IDLE, event.getRemoteAddr(), event.getChannel());
                                break;
                            case WRITER_IDLE:
                                listener.onChannelIdle(IdleState.WRITER_IDLE, event.getRemoteAddr(), event.getChannel());
                                break;
                            case READER_IDLE:
                                listener.onChannelIdle(IdleState.READER_IDLE, event.getRemoteAddr(), event.getChannel());
                                break;
                            case CLOSE:
                                listener.onChannelClose(event.getRemoteAddr(), event.getChannel());
                                break;
                            case CONNECT:
                                listener.onChannelConnect(event.getRemoteAddr(), event.getChannel());
                                break;
                            case EXCEPTION:
                                listener.onChannelException(event.getRemoteAddr(), event.getChannel());
                                break;
                            default:
                                break;
                        }
                    }
                } catch (Exception e) {
                    log.warn(this.getServiceName() + " service has exception. ", e);
                }
            }
            log.info(this.getServiceName() + " service end");
        }
    }
}
