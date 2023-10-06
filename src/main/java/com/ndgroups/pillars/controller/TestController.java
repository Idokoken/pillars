package com.ndgroups.pillars.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
//@RequestMapping("/test")
public class TestController {
    @Autowired
    private PostService postService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/test1")
    public ResponseEntity<?> findAllPost() {
        System.out.println(postService.getAllPost());
        return new ResponseEntity<List<Post>>(postService.getAllPost(), HttpStatus.OK);
    }
    @GetMapping("/test1/{id}")
    public ResponseEntity<Post> getOnePost(@PathVariable Integer id) {
        Optional<Post> optPost  = postService.getOnePost(id);
        return new ResponseEntity<Post>(optPost.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestParam("file") MultipartFile file, @RequestParam("title") String title,
                             @RequestParam("category") String category, @RequestParam("description") String description,
                             @RequestParam("author") String author, @RequestParam("isFeatured") Boolean isFeatured
                             ) {

        Post newPost = postService.createPost(file, title, category, description, author, isFeatured);
        return new ResponseEntity<Post>(newPost, HttpStatus.CREATED);
    }

    @PutMapping("/test2/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Integer id, @RequestParam("file") MultipartFile file, @RequestParam("title") String title,
                                        @RequestParam("category") String category, @RequestParam("description") String description,
                                        @RequestParam("author") String author, @RequestParam("isFeatured") Boolean isFeatured) throws IOException {

        Post updatedPost =  postService.updatePost(id, file, title, category, description, author, isFeatured);

        return new ResponseEntity<Post>(updatedPost, HttpStatus.CREATED);

    }


//test file upload
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String imgCover = postService.uploadFile(file);
        return new ResponseEntity<String>(imgCover, HttpStatus.CREATED);
    }


}
