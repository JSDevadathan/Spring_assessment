package com.example.movierental.validation.movies;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class GenreValidator implements ConstraintValidator<ValidGenre, String> {

    @Override
    public boolean isValid(String genre, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(genre) && genre.length() >= 2;
    }
}
