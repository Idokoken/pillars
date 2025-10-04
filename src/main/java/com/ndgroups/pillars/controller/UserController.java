package com.ndgroups.pillars.controller;

import com.ndgroups.pillars.Request.CreateUserRequest;
import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.model.User;
import com.ndgroups.pillars.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/add")
    public String getAddUserPage(@ModelAttribute("user") Post post) {
        return "admin/user/addPost";
    }

    @PostMapping("/add")
    public String createUser(@ModelAttribute("user") CreateUserRequest request) {
          User user = userService.createUser(request);
          return "";
    }

    @GetMapping("/{userId}")
    public String getUserById(@PathVariable Integer userId) {
           User user = userService.getUserById(userId);
           return "";
    }

    @GetMapping("/all")
    public String getAllUsers() {
          List<User> users = userService.getAllUsers();
          return "";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User request) {
            User user = userService.updateUser(id, request);
        return "";
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable  Integer userId) {
            userService.deleteUser(userId);
            return "";
    }

//    @GetMapping("/info")
//    public String getUserInfo(@RequestParam String email) {
//        User user = userService.getUserInfo(email);
//        return "";
//    }

    @GetMapping("/name")
    public String findByUsername(@RequestParam String username) {
        List<User> user = userService.findByUsername(username);
        return "";
    }

}
