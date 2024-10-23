package com.example.hocjpa_hodanit.Service.Validator;

import com.example.hocjpa_hodanit.Entity.DTO.RegisterDTO;
import com.example.hocjpa_hodanit.Service.UserServiceI;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {
    private final UserServiceI userServiceI;
    public RegisterValidator(UserServiceI userServiceI){
        this.userServiceI=userServiceI;
    }

    @Override
    public boolean isValid(RegisterDTO user, ConstraintValidatorContext Context) {
        boolean valid=true;
        if(!user.getPassword().equals(user.getConfirmPass())){
            Context.buildConstraintViolationWithTemplate("Password nhap khong chinh xac").
                    addPropertyNode("confirmPass").
                    addConstraintViolation().
                    disableDefaultConstraintViolation();
            valid=false;
        }
        if(this.userServiceI.checkEmail(user.getEmail())){
            Context.buildConstraintViolationWithTemplate("Email da ton tai. Vui long nhap email khac").
                    addPropertyNode("email").
                    addConstraintViolation().
                    disableDefaultConstraintViolation();
            valid=false;
        }

        return valid;
    }
}
