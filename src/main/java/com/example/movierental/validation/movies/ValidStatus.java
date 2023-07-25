package com.example.movierental.validation.movies;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StatusValidator.class)
@Documented
public @interface ValidStatus {

    String message() default "Invalid status. Must be either 'Available' or 'Rented'.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
