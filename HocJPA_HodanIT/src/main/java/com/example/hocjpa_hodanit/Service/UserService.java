package com.example.hocjpa_hodanit.Service;

import com.example.hocjpa_hodanit.Entity.DTO.RegisterDTO;
import com.example.hocjpa_hodanit.Entity.Roles;
import com.example.hocjpa_hodanit.Entity.User;
import com.example.hocjpa_hodanit.Repository.RoleRepository;
import com.example.hocjpa_hodanit.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceI {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository=roleRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getDetailUser(Integer id) {
        Optional<User> user=this.userRepository.findUserById(id);
        return user.orElse(null);
    }

    @Transactional
    @Override
    public void deleteUserById(Integer id) {
        this.userRepository.deleteUserById(id);
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> us=this.userRepository.findUserById(id);
        return us.orElse(null);
    }

    @Override
    @Transactional
    public void updateUser(User us) {
        this.userRepository.saveAndFlush(us);

    }

    @Override
    public Roles getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public User RegisterDTOtoUser(RegisterDTO registerDTO) {
        User user=new User();
        user.setFullname(registerDTO.getFirstName()+" "+registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        return user;

    }

    @Override
    public boolean checkEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }
}
