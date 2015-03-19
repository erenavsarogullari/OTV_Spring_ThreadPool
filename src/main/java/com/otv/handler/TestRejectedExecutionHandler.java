package com.otv.handler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class TestRejectedExecutionHandler implements RejectedExecutionHandler {

    private static final Logger log = Logger.getLogger(TestRejectedExecutionHandler.class);

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        log.debug(runnable.toString() + " : has been rejected");
    }
}
