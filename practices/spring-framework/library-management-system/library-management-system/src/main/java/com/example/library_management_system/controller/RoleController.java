package com.example.library_management_system.controller;

import com.example.library_management_system.model.Role;
import com.example.library_management_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role saveRole = roleService.createRole(role);
        return new ResponseEntity<>(saveRole, HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Role>> getRoles() {
        List<Role> roles = roleService.getRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRole(@PathVariable("id") long roleId) {
        Role role = roleService.getRole(roleId);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") long roleId, @RequestBody Role role) {
        Role updateRole = roleService.updateRole(roleId, role);
        return new ResponseEntity<>(updateRole, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable("id") long roleId) {
        Role deleteRole = roleService.deleteRole(roleId);
        return new ResponseEntity<>(deleteRole, HttpStatus.OK);
    }
}
