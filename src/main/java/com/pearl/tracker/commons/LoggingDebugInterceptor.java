package com.pearl.tracker.commons;

import com.pearl.tracker.annotations.Debugged;
import com.pearl.tracker.annotations.Loggable;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Loggable
@Debugged
@Interceptor
public class LoggingDebugInterceptor {

    @Inject
    Logger logger;


    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {

        logger.info("> {}", ic.getMethod());
        logger.info("> Parameters : {}", ic.getParameters());
        final Class<? extends Object> runtimeClasses = ic.getTarget().getClass();
        logger.info("> Runtime Class : {}", runtimeClasses.getName());
        logger.info("> Extended Classes : {}", new Object[]{runtimeClasses.getClasses()});
        logger.info("> Implemented Interfaces : {}", new Object[]{runtimeClasses.getInterfaces()});
        logger.info("> Annotations ({}) : {}", runtimeClasses.getAnnotations().length);

        final Class<?> declaringClasses = ic.getMethod().getDeclaringClass();

        logger.info("> Declaring Class : {}", declaringClasses);
        logger.info("> Extended Classes : {}", new Object[]{declaringClasses.getClasses()});
        logger.info("> Annotations ({}) : {}", declaringClasses.getAnnotations().length);

        try {
            return ic.proceed();
        } finally {
            logger.info("< {}", ic.getMethod());
        }
    }
}
