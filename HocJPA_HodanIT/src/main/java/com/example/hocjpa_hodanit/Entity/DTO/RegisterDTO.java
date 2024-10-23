package com.example.hocjpa_hodanit.Entity.DTO;

import com.example.hocjpa_hodanit.Service.Validator.RegisterChecked;
import com.example.hocjpa_hodanit.Service.Validator.StrongPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@RegisterChecked
public class RegisterDTO {
    @NotEmpty(message = "Khong duoc de trong")
    @Size(min=5,max=50,message = "Nhap du so ki tu")
    private String firstName;
    @NotEmpty(message = "Khong duoc de trong")
    @Size(min=1,max=50,message = "Nhap du so ki tu")
    private String lastName;
    @Email(message = "Nhap dung kieu du lieu email",regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    private String email;
    @StrongPassword
    private String password;

    private String ConfirmPass;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPass() {
        return ConfirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        ConfirmPass = confirmPass;
    }
}
