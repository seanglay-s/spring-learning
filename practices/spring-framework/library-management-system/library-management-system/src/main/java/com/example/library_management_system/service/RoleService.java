package com.example.library_management_system.service;

import com.example.library_management_system.model.Role;
import com.example.library_management_system.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getRole(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Role updateRole(Long roleId, Role role) {
        Role existingRole = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Not Found"));

        existingRole.setRoleName(role.getRoleName());
        roleRepository.save(existingRole);
        return existingRole;
    }

    public Role deleteRole(Long roleId) {
        Role existingRole = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Not Found"));

        roleRepository.deleteById(roleId);
        return existingRole;
    }
}

