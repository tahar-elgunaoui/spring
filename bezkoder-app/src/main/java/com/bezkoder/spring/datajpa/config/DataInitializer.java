package com.bezkoder.spring.datajpa.config;

import com.bezkoder.spring.datajpa.model.ERole;
import com.bezkoder.spring.datajpa.model.Role;
import com.bezkoder.spring.datajpa.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialize roles if they don't exist
        if (!roleRepository.existsByName(ERole.ROLE_USER)) {
            roleRepository.save(new Role(ERole.ROLE_USER));
        }
        
        if (!roleRepository.existsByName(ERole.ROLE_MODERATOR)) {
            roleRepository.save(new Role(ERole.ROLE_MODERATOR));
        }
        
        if (!roleRepository.existsByName(ERole.ROLE_ADMIN)) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }

        if (!roleRepository.existsByName(ERole.ROLE_SUPER_ADMIN)) {
            roleRepository.save(new Role(ERole.ROLE_SUPER_ADMIN));
        }

        
        System.out.println("Default roles initialized successfully!");
    }
}