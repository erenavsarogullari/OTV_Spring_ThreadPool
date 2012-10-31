package com.otv.start;

import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;

import com.otv.handler.TestRejectedExecutionHandler;
import com.otv.monitor.srv.IThreadPoolMonitorService;
import com.otv.monitor.srv.ThreadPoolMonitorService;
import com.otv.srv.ITestThreadPoolExecutorService;
import com.otv.srv.TestThreadPoolExecutorService;
import com.otv.task.TestTask;

/**
 * @author onlinetechvision.com
 * @since 17 Oct 2011
 * @version 1.0.0
 *
 */
public class Starter {
	
	private static Logger log = Logger.getLogger(TestRejectedExecutionHandler.class);
	
	IThreadPoolMonitorService threadPoolMonitorService;
	ITestThreadPoolExecutorService testThreadPoolExecutorService;
	
	public void start() {
		
		ThreadPoolExecutor executor = testThreadPoolExecutorService.createNewThreadPool();
		executor.allowCoreThreadTimeOut(true);
		
		threadPoolMonitorService.setExecutor(executor);
		
		Thread monitor = new Thread(threadPoolMonitorService);
		monitor.start();

		for(int i=1;i<10;i++) {
			executor.execute(new TestTask("Task"+i));
		}
		
		try	{
		    Thread.sleep(40000);
		} catch (Exception e)	{
		    log.error(e.getMessage());
		}
		
		for(int i=10;i<19;i++) {
			executor.execute(new TestTask("Task"+i));
		}
		
		executor.shutdown();
	}	

	public IThreadPoolMonitorService getThreadPoolMonitorService() {
		return threadPoolMonitorService;
	}

	public void setThreadPoolMonitorService(IThreadPoolMonitorService threadPoolMonitorService) {
		this.threadPoolMonitorService = threadPoolMonitorService;
	}

	public ITestThreadPoolExecutorService getTestThreadPoolExecutorService() {
		return testThreadPoolExecutorService;
	}

	public void setTestThreadPoolExecutorService(ITestThreadPoolExecutorService testThreadPoolExecutorService) {
		this.testThreadPoolExecutorService = testThreadPoolExecutorService;
	}
}
