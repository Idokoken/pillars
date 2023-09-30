package com.ndgroups.pillars.controller;

import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@Controller
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/create")
    public String getCreatePost(@ModelAttribute("post") Post post) {
        return "admin/post/add";
    }
//    @PostMapping("/create")
//    public String createPost(@Valid @ModelAttribute Post post, Model model) {
//         postService.createPost(post);
//         model.addAttribute("message", "post successfully created");
//         return "redirect:/api/admin";
//    }

    @PostMapping("/create")
    public String createPost(@RequestParam("file") MultipartFile file, @RequestParam("title") String title,
                             @RequestParam("category") String category, @RequestParam("description") String description,
                             @RequestParam("author") String author, @RequestParam("isFeatured") Boolean isFeatured,
                             Model model) {

         postService.createPost(file, title, category, description, author, isFeatured);
         model.addAttribute("message", "post successfully created");
         return "redirect:/admin/pillars";
    }

    @GetMapping
    public String getAllPosts(Model model) {
        List<Post> posts =  postService.getAllPost();
        model.addAttribute("posts", posts);
        return "posts";
    }
    @GetMapping("/{id}")
    public String getSinglePost(@PathVariable Integer id, Model model) {
        Optional<Post> post =  postService.getOnePost(id);
        model.addAttribute("post", post.get());
        return "singlePost";
    }
    @GetMapping("/search")
    public String getPostByCategory(Model model, @RequestParam(name="criteria", required = true) String criteria, @RequestParam(name="searchItem", required = true) String searchItem){
        List<Post> posts = postService.findByCriteria(criteria, searchItem);
        model.addAttribute("posts", posts);
        return "posts";
    }

    @GetMapping("/edit/{id}")
    public String getUpdatePostPage(@PathVariable Integer id, Model model) {
        Optional<Post>getPost  = postService.getOnePost(id);
        model.addAttribute("post", getPost.get());
        return "admin/post/edit";
    }
    @PostMapping("/edit")
    public String updatePost(@ModelAttribute  Post post, Model model) {
        postService.updatePost(post);
        model.addAttribute("message", "post updated successfully");
        return "redirect:/api/admin";
    }
    @RequestMapping("/delete/{id}")
    public String delPost(@PathVariable Integer id, Model model) {
        postService.delPost(id);
        model.addAttribute("message", "post successfully deleted");
        return "redirect:/api/admin";
    }


}
