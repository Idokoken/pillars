package com.ndgroups.pillars.controller;

import com.ndgroups.pillars.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class IndexController {
    @Autowired
    private PostService postService;

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
    @GetMapping("/editorial")
    public String getEditorial() {
        return  "editorial";
    }
    @GetMapping("/advert")
    public String getAdvert() {
        return  "advert";
    }
    @GetMapping("/privacy")
    public String getPrivacyPolicy() {
        return  "privacyPolicy";
    }

    @GetMapping("/admin")
    public  String adminPage(Model model) {
        model.addAttribute("posts", postService.getAllPost());
        return "admin/index";
    }
}



