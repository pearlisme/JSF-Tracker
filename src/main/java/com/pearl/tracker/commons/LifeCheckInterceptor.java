package com.pearl.tracker.commons;

import com.pearl.tracker.annotations.LifeCheck;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


@LifeCheck
@Interceptor
public class LifeCheckInterceptor {

    @Inject
    Logger logger;

    @PostConstruct
    private void contruct(InvocationContext ic) {
        logger.info("Constructed {}", ic.getTarget().toString());
    }


    @PreDestroy
    private void destruct(InvocationContext ic) {
        logger.info("Destructed {}", ic.getTarget().toString());
    }

}
