package com.desafiomvc;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.desafiomvc.entities.Role;
import com.desafiomvc.repositories.IRoleRepository;

@Component
public class SetuData implements ApplicationListener<ContextRefreshedEvent>{
    boolean alreadySetup = false;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup)
            return;
        createRoleIfNotFound("ADMIN");
    }

    @Transactional
    Role createRoleIfNotFound(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}
