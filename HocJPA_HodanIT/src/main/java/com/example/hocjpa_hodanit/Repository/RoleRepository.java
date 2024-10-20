package com.example.hocjpa_hodanit.Repository;

import com.example.hocjpa_hodanit.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {
    Roles findByName(String name);
}
