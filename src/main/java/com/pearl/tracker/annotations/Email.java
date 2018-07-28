package com.pearl.tracker.annotations;

import javax.validation.Constraint;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Target({ElementType.METHOD, ElementType.FIELD,
ElementType.CONSTRUCTOR,ElementType.ANNOTATION_TYPE,ElementType.TYPE
,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Size(min = 5)
@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
        + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*"
        + "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
@Constraint(validatedBy = {})
public @interface Email {
    String messages() default "javax.validation.constrains.Email.message";
}
