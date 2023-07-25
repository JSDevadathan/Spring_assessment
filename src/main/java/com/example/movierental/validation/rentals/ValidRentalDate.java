package com.example.movierental.validation.rentals;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RentalDateValidator.class)
@Documented
public @interface ValidRentalDate {

    String message() default "Rental date should be in the past or present";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
