package com.ndgroups.pillars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class IndexController {

    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String createMessage(Model model) {
        model.addAttribute("greeting", "message sent successfully");
        return "contact";
    }

    @GetMapping("/about")
    public String getAbout() {
        return  "about";
    }

    @GetMapping("/admin")
    public  String adminPage(Model model) {
        return "admin/index";
    }
}



