package com.example.movierental.validation.rentals;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ReturnDateValidator implements ConstraintValidator<ValidReturnDate, LocalDate> {

    @Override
    public boolean isValid(
            LocalDate returnDate, ConstraintValidatorContext constraintValidatorContext) {
        if (returnDate == null) {
            return false;
        }

        LocalDate currentDate = LocalDate.now();
        return !returnDate.isBefore(currentDate);
    }
}
