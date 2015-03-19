package com.otv.srv;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import com.otv.handler.TestRejectedExecutionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestThreadPoolExecutorService {

    @Autowired
    private int corePoolSize;
    @Autowired
    private int maxPoolSize;
    @Autowired
    private long keepAliveTime;
    @Autowired
    private int queueCapacity;
    @Autowired
    private TestRejectedExecutionHandler testRejectedExecutionHandler;

    public ThreadPoolExecutor createNewThreadPool() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(getCorePoolSize(),
                getMaxPoolSize(),
                getKeepAliveTime(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(getQueueCapacity()),
                getTestRejectedExecutionHandler());
        return executor;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public TestRejectedExecutionHandler getTestRejectedExecutionHandler() {
        return testRejectedExecutionHandler;
    }

    public void setTestRejectedExecutionHandler(TestRejectedExecutionHandler testRejectedExecutionHandler) {
        this.testRejectedExecutionHandler = testRejectedExecutionHandler;
    }

}
