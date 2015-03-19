package com.otv.config;

import com.otv.handler.TestRejectedExecutionHandler;
import com.otv.monitor.srv.ThreadPoolMonitorService;
import com.otv.srv.TestThreadPoolExecutorService;
import com.otv.start.Starter;
import com.otv.task.TestTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.otv"})
public class ApplicationConfig {

    @Bean
    public TestTask testTask() {
        return new TestTask();
    }

    @Bean
    public long monitoringPeriod() {
        return 5;
    }

    @Bean
    public ThreadPoolMonitorService threadPoolMonitorService(long monitoringPeriod) {
        ThreadPoolMonitorService threadPoolMonitorService = new ThreadPoolMonitorService();
        threadPoolMonitorService.setMonitoringPeriod(monitoringPeriod);
        return threadPoolMonitorService;
    }

    @Bean
    public TestRejectedExecutionHandler testRejectedExecutionHandler() {
        return new TestRejectedExecutionHandler();
    }

    @Bean
    public int corePoolSize() {
        return 1;
    }

    @Bean
    public long keepAliveTime() {
        return 10;
    }

    @Bean
    public int maxPoolSize() {
        return 3;
    }

    @Bean
    public int queueCapacity() {
        return 3;
    }

    @Bean
    public TestThreadPoolExecutorService testThreadPoolExecutorService(TestRejectedExecutionHandler testRejectedExecutionHandler, int corePoolSize, long keepAliveTime, int maxPoolSize, int queueCapacity) {
        TestThreadPoolExecutorService testThreadPoolExecutorService = new TestThreadPoolExecutorService();
        testThreadPoolExecutorService.setCorePoolSize(corePoolSize);
        testThreadPoolExecutorService.setMaxPoolSize(maxPoolSize);
        testThreadPoolExecutorService.setKeepAliveTime(keepAliveTime);
        testThreadPoolExecutorService.setQueueCapacity(queueCapacity);
        testThreadPoolExecutorService.setTestRejectedExecutionHandler(testRejectedExecutionHandler);
        return testThreadPoolExecutorService;
    }

    @Bean
    public Starter starter(ThreadPoolMonitorService threadPoolMonitorService, TestThreadPoolExecutorService testThreadPoolExecutorService) {
        Starter starter = new Starter();
        starter.setTestThreadPoolExecutorService(testThreadPoolExecutorService);
        starter.setThreadPoolMonitorService(threadPoolMonitorService);
        return starter;
    }

}
