package com.example.jwt.core.security.validators.age;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
@Documented
public @interface ValidAge {

    String message() default "{user.age.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
