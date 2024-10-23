package com.example.hocjpa_hodanit.Repository;

import com.example.hocjpa_hodanit.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    Optional<User> findUserById(Integer id);//Xem chi tiet 1 user

    void deleteUserById(Integer id);//DeletebyId

    boolean existsByEmail(String email);





}
