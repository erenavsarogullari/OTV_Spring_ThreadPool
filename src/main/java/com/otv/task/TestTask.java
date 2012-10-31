package com.otv.task;

import org.apache.log4j.Logger;

/**
 * @author onlinetechvision.com
 * @since 17 Oct 2011
 * @version 1.0.0
 *
 */
public class TestTask implements Runnable {
	
	private static Logger log = Logger.getLogger(TestTask.class);
	String taskName;

	public TestTask() {
	}

	public TestTask(String taskName) {
		this.taskName = taskName;
	}

	public void run() {
		try {
			log.debug(this.taskName + " : is started.");
			Thread.sleep(10000);
			log.debug(this.taskName + " : is completed.");
		} catch (InterruptedException e) {
			log.error(this.taskName + " : is not completed!");
			e.printStackTrace();
		}		
	}

	@Override
	public String toString() {
		return (getTaskName());
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
}
