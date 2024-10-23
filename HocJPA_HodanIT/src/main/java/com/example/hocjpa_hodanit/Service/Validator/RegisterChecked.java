package com.example.hocjpa_hodanit.Service.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.*;

@Constraint(validatedBy = RegisterValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RegisterChecked {
    String message() default "User register validation failed ";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
