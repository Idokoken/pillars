package com.ndgroups.pillars.service;

import com.ndgroups.pillars.model.User;
import com.ndgroups.pillars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
    public Optional<User> getOneUser(Integer id) {
        return userRepository.findById(id);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
