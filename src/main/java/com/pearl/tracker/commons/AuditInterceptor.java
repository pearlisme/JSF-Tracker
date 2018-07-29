package com.pearl.tracker.commons;

import com.pearl.tracker.annotations.Auditable;
import org.slf4j.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Auditable
@Interceptor
@Priority(2010)
public class AuditInterceptor {

    @Inject
    Logger logger;


    @AroundInvoke
    private Object intercept(InvocationContext invocationContext) throws Exception {
        long begin = System.currentTimeMillis();
        try {
            return invocationContext.proceed();
        } finally {
            logger.info("Took {}", (System.currentTimeMillis() - begin));
        }

    }

}
