package com.delineneo.web.validation;

/**
 * User: deline
 * Date: 5/06/13
 * Time: 6:35 PM
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = MyCustomConstraintValidator.class)
public @interface MyCustomConstraint {
    String message() default "Default error message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };
}
