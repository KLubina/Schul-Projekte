package com.example.jwt.core.security.validators.country;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CountryValidator.class)
@Documented
public @interface ValidCountry {

    String message() default "{user.country.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
