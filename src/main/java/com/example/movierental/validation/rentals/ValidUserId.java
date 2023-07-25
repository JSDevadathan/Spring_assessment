package com.example.movierental.validation.rentals;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserIdValidator.class)
@Documented
public @interface ValidUserId {

    String message() default "Rented user-id  should be provided";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
