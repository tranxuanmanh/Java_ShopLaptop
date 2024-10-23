package com.example.hocjpa_hodanit.Service.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.*;

@Constraint(validatedBy = StrongPasswordValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StrongPassword {
    String message() default "Nhap toi thieu 8 ki tu,bao gom chu hoa,chu thuong,chu so";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
