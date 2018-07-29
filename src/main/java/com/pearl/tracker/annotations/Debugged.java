package com.pearl.tracker.annotations;

import javax.enterprise.inject.Vetoed;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;


@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Vetoed
public @interface Debugged {
}