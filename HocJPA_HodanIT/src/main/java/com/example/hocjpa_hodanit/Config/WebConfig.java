package com.example.hocjpa_hodanit.Config;

import com.example.hocjpa_hodanit.Service.CustomUserdetailService;
import com.example.hocjpa_hodanit.Service.UserService;
import jakarta.servlet.DispatcherType;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableMethodSecurity(securedEnabled = true)
public class WebConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public UserDetailsService userDetailsService(UserService userService){
//        return new CustomUserdetailService(userService);
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(
//            PasswordEncoder passwordEncoder,
//            UserDetailsService userDetailsService
//    ){
//        DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder);
//      // authProvider.setHideUserNotFoundExceptions(false);
//        return authProvider;
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http
//                .authorizeHttpRequests(
//                check->check.
//                        requestMatchers("/","/user/home","/user/shop","/user/login","/ClientStyle/**","/Image/**").permitAll().
//                                anyRequest().authenticated()).
//                formLogin(login->login.
//                        loginPage("/user/login").permitAll()
//                        .successForwardUrl("/user/home"));
//
//
//        return http.build();
//
//
//    }

 }
