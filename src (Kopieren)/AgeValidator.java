package com.example.jwt.core.security.validators.age;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<com.example.jwt.core.security.validators.age.ValidAge, Integer> {

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext context) {
        return age != null && age >= 1 && age <= 199;
    }
}
