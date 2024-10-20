package com.example.hocjpa_hodanit.Service;

import com.example.hocjpa_hodanit.Entity.Roles;
import com.example.hocjpa_hodanit.Entity.User;

import java.util.List;

public interface UserServiceI {
    User save(User user);
    User getUserById(Integer id);
    List<User> getAllUser();
    User getDetailUser(Integer id);
    void deleteUserById(Integer id);

    void updateUser(User us);

    Roles getRoleByName(String name);
}
