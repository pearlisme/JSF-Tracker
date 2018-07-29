package com.pearl.tracker.commons;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@Dependent
public class LoggerProducers {

    @Produces
    private Logger createLogger(InjectionPoint ip) {

        return LogManager.getLogger(ip.getMember().getDeclaringClass().getName());

    }
}
