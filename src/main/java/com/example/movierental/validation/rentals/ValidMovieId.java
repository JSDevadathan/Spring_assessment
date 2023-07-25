package com.example.movierental.validation.rentals;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MovieIdValidator.class)
@Documented
public @interface ValidMovieId {

    String message() default "Rented movie-id  should be provided";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
