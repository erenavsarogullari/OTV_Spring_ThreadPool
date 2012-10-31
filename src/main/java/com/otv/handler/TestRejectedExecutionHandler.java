package com.otv.handler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;

/**
 * @author onlinetechvision.com
 * @since 17 Oct 2011
 * @version 1.0.0
 *
 */
public class TestRejectedExecutionHandler implements RejectedExecutionHandler {
	
	private static Logger log = Logger.getLogger(TestRejectedExecutionHandler.class);
	
	public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
		log.debug(runnable.toString() + " : has been rejected");
	}
}
