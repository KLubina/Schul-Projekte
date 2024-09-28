package com.example.jwt.core.security.validators.country;

import com.example.jwt.domain.county.CountryRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryValidator implements ConstraintValidator<ValidCountry, String> {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        return countryRepository.existsByCountryNameOrAbbreviation(value, value);
    }
}
