package com.ndgroups.pillars.controller;

import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/api")
public class IndexController {
    @Autowired
    private PostService postService;

    @GetMapping
    public String getHome(Model model){
        List<Post> posts = postService.getAllPost();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/api/contact")
    public String getContact() {
        return "pages/contact";
    }

    @PostMapping("/api/contact")
    public String createMessage(Model model) {
        model.addAttribute("greeting", "message sent successfully");
        return "pages/contact";
    }
    @GetMapping("/api/about")
    public String getAbout() {
        return  "pages/about";
    }
    @GetMapping("/api/editorial")
    public String getEditorial() {
        return  "pages/editorial";
    }
    @GetMapping("/api/advert")
    public String getAdvert() {
        return  "pages/advert";
    }
    @GetMapping("/api/privacy")
    public String getPrivacyPolicy() {
        return  "pages/privacyPolicy";
    }

    @GetMapping("/api/admin")
    public  String adminPage(Model model) {
        model.addAttribute("posts", postService.getAllPost());
        return "admin/index";
    }
}



