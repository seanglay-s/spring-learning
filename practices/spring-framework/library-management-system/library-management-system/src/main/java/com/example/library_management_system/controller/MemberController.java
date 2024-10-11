package com.example.library_management_system.controller;

import com.example.library_management_system.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;
}
