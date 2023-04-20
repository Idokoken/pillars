package com.ndgroups.pillars.controller;

import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/test")
public class TestController {
    @Autowired
    private PostService postService;

    @GetMapping("/test1")
    public ResponseEntity<?> findAllPost() {
        System.out.println(postService.getAllPost());
        return new ResponseEntity<List<Post>>(postService.getAllPost(), HttpStatus.OK);
    }

    @PostMapping("/test2")
    public ResponseEntity<?> updatePost(@RequestBody Post post) {
        Optional<Post> upPost =  postService.updatePost(post);

        return new ResponseEntity<Post>(upPost.get(), HttpStatus.CREATED);
    }

}
