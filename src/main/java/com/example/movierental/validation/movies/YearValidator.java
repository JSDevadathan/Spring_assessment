package com.example.movierental.validation.movies;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.Year;

public class YearValidator implements ConstraintValidator<ValidYear, Year> {

    @Override
    public boolean isValid(
            Year releaseYear, ConstraintValidatorContext constraintValidatorContext) {
        if (releaseYear == null) {
            return false;
        }
        Year currentYear = Year.now();
        return releaseYear.isBefore(currentYear) || releaseYear.equals(currentYear);
    }
}
