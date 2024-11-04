package com.example.hocjpa_hodanit.Service;

import com.example.hocjpa_hodanit.Entity.DTO.RegisterDTO;
import com.example.hocjpa_hodanit.Entity.Roles;
import com.example.hocjpa_hodanit.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserServiceI {
    User save(User user);
    User getUserById(Integer id);
    Page<User> getAllUser(Pageable pageable);
    User getDetailUser(Integer id);
    void deleteUserById(Integer id);

    void updateUser(User us);

    Roles getRoleByName(String name);

    User RegisterDTOtoUser(RegisterDTO registerDTO);
    boolean checkEmail(String email);

    User getUserByEmail(String email);
}
