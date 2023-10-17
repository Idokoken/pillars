package com.ndgroups.pillars.controller;

import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

//@Controller
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

//    @GetMapping
//    public String getAllPosts(Model model) {
//        List<Post> posts =  postService.getAllPost();
//        model.addAttribute("posts", posts);
//        return "posts";
//    }
    @GetMapping
    public String getPostsPage(@PageableDefault(size = 5)Pageable pageable, Model model) {
        Page<Post> posts = postService.getPagePost(pageable);
         model.addAttribute("posts", posts);

        return "posts";
    }
    @GetMapping("/{id}")
    public String getSinglePost(@PathVariable Integer id, Model model, HttpServletRequest request) {
        String currentUrl  = request.getRequestURL().toString();
        Optional<Post> post =  postService.getOnePost(id);
        model.addAttribute("url", currentUrl);
        model.addAttribute("post", post.get());
        return "singlePost";
    }
    @GetMapping("/search")
    public String getPostByCategory(@RequestParam(defaultValue = "") String keyword,
                                    @PageableDefault(size = 5) Pageable pageable, Model model){
        Page<Post> posts = postService.searchPost(keyword, pageable);
        model.addAttribute("posts", posts);
        model.addAttribute("title", "search results");
        return "pages/search-result";
    }
    @GetMapping("/category/{category}")
    public String getPostCategory(@PathVariable("category") String category, Model model,
                                  @PageableDefault(size  = 5) Pageable pageable) {
      Page<Post> posts = postService.getPostByCategory(category, pageable);
      model.addAttribute("posts", posts);

      return "posts";
    }


//    create post
    @GetMapping("/create")
    public String getCreatePost(@ModelAttribute("post") Post post) {
        return "admin/addPost";
    }
//    @PostMapping("/create")
//    public String createPost(@Valid @ModelAttribute Post post, Model model) {
//         postService.createPost(post);
//         model.addAttribute("message", "post successfully created");
//         return "redirect:/admin/pillars";
//    }

    @PostMapping("/create")
    public String createPost(@RequestParam("file") MultipartFile file, @RequestParam("title") String title,
                             @RequestParam("category") String category, @RequestParam("description") String description,
                             @RequestParam("author") String author, @RequestParam("isFeatured") Boolean isFeatured,
                             Model model) {
//        if(errors.hasErrors()){
//            return "admin/addPost";
//        }

        postService.createPost(file, title, category, description, author, isFeatured);
        model.addAttribute("message", "post successfully created");
        return "admin/addPost";
    }

    @GetMapping("/edit/{id}")
    public String getUpdatePostPage(@PathVariable Integer id, Model model) {
        Optional<Post>getPost  = postService.getOnePost(id);
        model.addAttribute("post", getPost.get());
        return "admin/editPost";
    }
    @PostMapping("/edit/{id}")
    public String updatePost(Model model, @PathVariable Integer id, @RequestParam("imgCoverUrl") MultipartFile file,
                             @RequestParam("title") String title, @RequestParam("category") String category,
                             @RequestParam("description") String description, @RequestParam("author") String author,
                             @RequestParam("isFeatured") Boolean isFeatured
    ) throws IOException {
        Post newPost = postService.updatePost(id, file, title, category, description, author, isFeatured);
        model.addAttribute("message", "post updated successfully");
        return "redirect:/admin/pillars?success";
    }
    @RequestMapping("/delete/{id}")
    public String delPost(@PathVariable Integer id, Model model) {
        postService.delPost(id);
        model.addAttribute("message", "post successfully deleted");
        return "redirect:/admin/pillars";
    }


}
