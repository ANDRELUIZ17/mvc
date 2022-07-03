package com.desafiomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiomvc.entities.User;

public interface IUserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
