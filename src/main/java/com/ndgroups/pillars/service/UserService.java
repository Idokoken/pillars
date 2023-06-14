package com.ndgroups.pillars.service;

import com.ndgroups.pillars.model.User;
import com.ndgroups.pillars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
    public Optional<User> getOneUser(Integer id) {

        return userRepository.findById(id);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> updateUser(User user) {
        Optional<User> optUser = userRepository.findById(user.getId());
        if(optUser.isPresent()) {
            User getUser  = optUser.get();
            getUser.setName(user.getName());
            getUser.setEmail(user.getEmail());
            getUser.setSalt(user.getSalt());
            getUser.setPassword(passwordEncoder.encode(user.getPassword()));
            getUser.setAdmin(getUser.getAdmin());

            userRepository.save(getUser);

            return Optional.of(getUser);
        }
        return Optional.empty();
    }

    public void deleteUser(Integer id) {
        Optional<User> getUser = userRepository.findById(id);
        userRepository.delete(getUser.get());
    }

}
