package com.otv.monitor.srv;

import java.util.concurrent.ThreadPoolExecutor;

public interface IThreadPoolMonitorService extends Runnable {

	public void monitorThreadPool();
	
	public ThreadPoolExecutor getExecutor();
	
	public void setExecutor(ThreadPoolExecutor executor);
	
}
