package com.example.library_management_system.service;

import com.example.library_management_system.model.Member;
import com.example.library_management_system.model.Role;
import com.example.library_management_system.repository.MemberRepository;
import com.example.library_management_system.repository.RoleRepository;
import com.example.library_management_system.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(MemberRepository memberRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(Member member) {
        if (memberRepository.existsByEmail(member.getEmail())) {
            throw new RuntimeException("This member has already been registered");
        }

        String hashedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(hashedPassword);

        Role memberRole = roleRepository.findByRoleName("Member");
        if (memberRole != null) {
            member.setRole(memberRole);
        } else {
            throw new IllegalArgumentException("Role 'Member' not found");
        }

        memberRepository.save(member);
        return JwtTokenUtil.generateToken(member.getFullName());
    }

    // Login method
    public String login(String email, String password) {
        Member existingMember = memberRepository.findByEmail(email);
        if (existingMember == null) {
            throw new IllegalArgumentException("Member not found");
        }

        if (!passwordEncoder.matches(password, existingMember.getPassword())) {
            throw new IllegalArgumentException("Password is incorrect");
        }
        return JwtTokenUtil.generateToken(existingMember.getFullName());

    }
}
