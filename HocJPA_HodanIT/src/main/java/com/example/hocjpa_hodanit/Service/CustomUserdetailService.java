package com.example.hocjpa_hodanit.Service;

import com.example.hocjpa_hodanit.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
public class CustomUserdetailService implements UserDetailsService {
    private final UserServiceI userServiceI;
    @Autowired
    public CustomUserdetailService(UserServiceI userServiceI) {
        this.userServiceI = userServiceI;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User us1=this.userServiceI.getUserByEmail(username);
        if(us1==null){
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
         us1.getEmail(),
         us1.getPassword(),
         Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
