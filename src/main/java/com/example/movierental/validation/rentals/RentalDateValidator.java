package com.example.movierental.validation.rentals;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class RentalDateValidator implements ConstraintValidator<ValidRentalDate, LocalDate> {

    @Override
    public boolean isValid(
            LocalDate rentalDate, ConstraintValidatorContext constraintValidatorContext) {
        if (rentalDate == null) {
            return false;
        }

        LocalDate currentDate = LocalDate.now();
        return !rentalDate.isAfter(currentDate);
    }
}
