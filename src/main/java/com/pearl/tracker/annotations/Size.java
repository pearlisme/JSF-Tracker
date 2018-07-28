package com.pearl.tracker.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface Size {

    int min() default 0;
    int max() default Integer.MAX_VALUE;

    String message() default "javax.validation.constrains.size.message";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}
