package com.ndgroups.pillars.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String getLogin() {
        return "pages/login";
    }

    //logout route
//    @PostMapping("/logout")
//    public String logout() {
//        return "redirect:/login?logout";
//    }

}
