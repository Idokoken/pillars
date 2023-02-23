package com.ndgroups.pillars.controller;

import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public String createPost(@RequestBody Post post) {
        postService.createPost(post);
        return "post";
    }
    @GetMapping("/{id}")
    public String getSinglePost(@PathVariable Integer id) {
        postService.getOnePost(id);
        return "singlepost";
    }

    @GetMapping
    public String getAllPosts() {
        return "posts";
    }

}
