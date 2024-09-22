package com.example.jwt.core.security.validators.ahv;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AhvValidator.class)
public @interface AHV {

    String message() default "{javax.validation.constraints.Ahv.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

