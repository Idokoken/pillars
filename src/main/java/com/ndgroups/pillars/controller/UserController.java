package com.ndgroups.pillars.controller;

import com.ndgroups.pillars.model.User;
import com.ndgroups.pillars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser( @RequestBody User user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
    @GetMapping("/allusers")
    public ResponseEntity<?> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User>getOneUser(@PathVariable Integer id) {
        Optional<User> getUser = userService.getOneUser(id);
        return new ResponseEntity<User>(getUser.get() ,HttpStatus.OK);
   }
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestParam User user){
    Optional<User>getUser = userService.updateUser(user);
    return new ResponseEntity<User>(getUser.get(), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }




}


