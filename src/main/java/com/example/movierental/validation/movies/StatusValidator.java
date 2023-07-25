package com.example.movierental.validation.movies;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class StatusValidator implements ConstraintValidator<ValidStatus, String> {

    private static final String[] ALLOWED_STATUSES = {"Available", "Rented"};

    @Override
    public boolean isValid(String status, ConstraintValidatorContext constraintValidatorContext) {
        if (status == null || status.trim().isEmpty()) {
            return false;
        }

        return Arrays.stream(ALLOWED_STATUSES).anyMatch(s -> s.equals(status));
    }
}
