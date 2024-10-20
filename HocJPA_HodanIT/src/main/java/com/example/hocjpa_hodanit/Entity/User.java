package com.example.hocjpa_hodanit.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Khong duoc de trong")
    @Size(min=5,message = "Fullname phai co 3 ki tu")
    private String fullname;
    @NotBlank(message = "Khong duoc de trong")
    @Size(min=2,message = "Nhap toi thieu 2 chu so")
    private String password;
    @Size(min=10,max = 11,message = "Nhap 10 chu so")
    private String phone;
    @NotNull
    @Size(min=2,message = "Address phai co it nhat 2 ki tu")
    private String address;
    @Email(message = "Nhap dung kieu du lieu email",regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    private String email;

    private String avatar;
    @ManyToOne
    @JoinColumn(name="role_id",referencedColumnName = "id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
   private List<Orders> orders;


    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User(int id,String fullname, String password, String phone, String address, String email,String avatar) {
        this.id=id;
        this.fullname = fullname;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.avatar=avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
