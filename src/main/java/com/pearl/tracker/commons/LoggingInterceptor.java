package com.pearl.tracker.commons;

import com.pearl.tracker.annotations.Loggable;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


//@Loggable(debug = false)
@Loggable
@Interceptor
public class LoggingInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {

        logger.info("> {}", ic.getMethod());
        try {
            return ic.proceed();
        } finally {
            logger.info("< {}", ic.getMethod());
        }

    }

}
