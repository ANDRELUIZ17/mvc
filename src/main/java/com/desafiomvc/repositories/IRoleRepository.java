package com.desafiomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiomvc.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}
