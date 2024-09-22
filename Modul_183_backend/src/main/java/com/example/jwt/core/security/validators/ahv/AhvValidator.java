package com.example.jwt.core.security.validators.ahv;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class AhvValidator implements ConstraintValidator<AHV, String> {

    private static final String AHV_REGEX = "^756\\.\\d{4}\\.\\d{4}\\.\\d{2}$";


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }


        if (!value.matches(AHV_REGEX)) {
            return false;
        }


        String numericPart = value.replace(".", "");

        return isValidCheckDigit(numericPart);
    }

    private boolean isValidCheckDigit(String ahvNumber) {
        // Ensure the AHV number has exactly 13 characters (including the check digit)
        if (ahvNumber.length() != 13) {
            return false;
        }

        int sum = 0;

        // Calculate the weighted sum for the first 12 digits (without the check digit)
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(ahvNumber.charAt(i));
            // Multiply digits alternately by 1 and 3, starting from the first digit
            if (i % 2 == 0) {
                sum += digit * 1;  // Even index (0-based): multiply by 1
            } else {
                sum += digit * 3;  // Odd index (0-based): multiply by 3
            }
        }

        // Calculate the expected check digit
        int expectedCheckDigit = (10 - (sum % 10)) % 10;

        // Extract the actual check digit from the AHV number
        int actualCheckDigit = Character.getNumericValue(ahvNumber.charAt(12));

        // Compare the calculated check digit with the actual check digit
        return expectedCheckDigit == actualCheckDigit;
    }
}
