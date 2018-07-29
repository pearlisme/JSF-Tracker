package com.pearl.tracker.annotations;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@Pattern(regexp = "[0-9]{10}")
@Documented
public @interface Mobile {
}
