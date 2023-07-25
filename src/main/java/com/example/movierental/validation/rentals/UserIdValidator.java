package com.example.movierental.validation.rentals;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class UserIdValidator implements ConstraintValidator<ValidUserId, String> {

    @Override
    public boolean isValid(String userId, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(userId) && !userId.trim().isEmpty() && userId.length() >= 2;
    }
}
