package com.desafiomvc.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.desafiomvc.entities.User;
import com.desafiomvc.web.UserRegistrationDto;

public interface IUserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
    User findByUsername(String username);
    
}
