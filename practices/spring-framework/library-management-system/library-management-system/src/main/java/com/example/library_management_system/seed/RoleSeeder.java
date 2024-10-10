package com.example.library_management_system.seed;

import com.example.library_management_system.model.Role;
import com.example.library_management_system.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RoleSeeder implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public RoleSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            List<Role> roles = new ArrayList<Role>();
            roles.addAll(Arrays.asList(new Role(null, "Admin"), new Role(null, "Librarian"), new Role(null, "Member")));

            roleRepository.saveAll(roles);
            System.out.println("Roles seeded successfully!");
        } else {
            System.out.println("Roles already exist!");
        }
    }
}
