package com.ndgroups.pillars.controller;

import com.ndgroups.pillars.model.User;
import com.ndgroups.pillars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(User user) {
        return "register";
    }
    @GetMapping("/login")
    public String getLoginPage(User user) {
        return "login";
    }
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, Errors errors, Model model){
        if(errors.hasErrors()){
            return "register";
        } else {
            User newUser = userService.createUser(user);
            model.addAttribute("message", "Registeration successful");
            return "redirect:/api/auth/login";
        }

    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user){
        User newUser = userService.createUser(user);
        return "redirect:/";
    }
}
