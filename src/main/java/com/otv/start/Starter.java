package com.otv.start;

import java.util.concurrent.ThreadPoolExecutor;
import com.otv.monitor.srv.ThreadPoolMonitorService;
import com.otv.srv.TestThreadPoolExecutorService;
import com.otv.task.TestTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Starter {

    @Autowired
    private ThreadPoolMonitorService threadPoolMonitorService;

    @Autowired
    private TestThreadPoolExecutorService testThreadPoolExecutorService;

    public void start() {
        ThreadPoolExecutor executor = testThreadPoolExecutorService.createNewThreadPool();
        executor.allowCoreThreadTimeOut(true);
        threadPoolMonitorService.setExecutor(executor);
        threadPoolMonitorService.start();
        for (int i = 1; i < 19; i++) {
            executor.execute(new TestTask("Task" + i));
        }
        executor.shutdown();
    }

    public ThreadPoolMonitorService getThreadPoolMonitorService() {
        return threadPoolMonitorService;
    }

    public void setThreadPoolMonitorService(ThreadPoolMonitorService threadPoolMonitorService) {
        this.threadPoolMonitorService = threadPoolMonitorService;
    }

    public TestThreadPoolExecutorService getTestThreadPoolExecutorService() {
        return testThreadPoolExecutorService;
    }

    public void setTestThreadPoolExecutorService(TestThreadPoolExecutorService testThreadPoolExecutorService) {
        this.testThreadPoolExecutorService = testThreadPoolExecutorService;
    }

}
