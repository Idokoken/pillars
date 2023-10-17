package com.ndgroups.pillars.controller;

import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public String getHome(@PageableDefault(size = 6) Pageable pageable, Model model){
        Page<Post> posts = postService.getPagePost(pageable);
        model.addAttribute("posts", posts);

        return "index";
    }

    @GetMapping("/contact")
    public String getContact() {
        return "pages/contact";
    }

    @PostMapping("/contact")
    public String createMessage(Model model) {
        model.addAttribute("greeting", "message sent successfully");
        return "pages/contact";
    }
    @GetMapping("/about")
    public String getAbout() {
        return  "pages/about";
    }
    @GetMapping("/editorial")
    public String getEditorial() {
        return  "pages/editorial";
    }
    @GetMapping("/advert")
    public String getAdvert() {
        return  "pages/advert";
    }
    @GetMapping("/privacy")
    public String getPrivacyPolicy() {
        return  "pages/privacyPolicy";
    }
//    @GetMapping("/error")
//    public String getErrorPage() {
//        return "pages/errorpage";
//    }

    @GetMapping("/admin/pillars")
    public  String adminPage(@PageableDefault(size = 10) Pageable pageable, Model model) {
        Page<Post> posts = postService.getPagePost(pageable);
        model.addAttribute("posts", posts);
        return "admin/adminDashboard";
    }

}



