package com.example.library_management_system.controller;

import com.example.library_management_system.handler.ResponseHandler;
import com.example.library_management_system.model.Member;
import com.example.library_management_system.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody Member member) {
        Member saveMember = authenticationService.register(member);
        return ResponseHandler.generateResponse("Member has been registered successfully", HttpStatus.OK, saveMember);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Member member = authenticationService.login(email, password);
        return ResponseHandler.generateResponse("Login has been successfully", HttpStatus.OK, member);
    }
}
