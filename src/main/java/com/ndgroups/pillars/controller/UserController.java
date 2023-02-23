package com.ndgroups.pillars.controller;

import com.ndgroups.pillars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/auth")
public class UserController {

    @GetMapping("/register")
    public String registerUser() {
        return "register";
    }

    @GetMapping("/login")
    public String loginUser() {
        return "login";
    }
}


