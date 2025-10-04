package com.ndgroups.pillars.service.impl;

import com.ndgroups.pillars.Request.CreateUserRequest;
import com.ndgroups.pillars.exception.AlreadyExistException;
import com.ndgroups.pillars.exception.ResourceNotFoundException;
import com.ndgroups.pillars.model.User;
import com.ndgroups.pillars.repository.UserRepository;
import com.ndgroups.pillars.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public User createUser(CreateUserRequest request) {
        return Optional.of(request)
                .filter(user -> !userRepository.existsByEmail(request.getEmail()))
                .map(req -> {
                    User user = new User();
                    user.setUsername(request.getUsername());
                    user.setEmail(request.getEmail());
                    user.setPassword(passwordEncoder.encode(request.getPassword()));
                    user.setRole((request.getRole()));
                    return userRepository.save(user);
                }).orElseThrow(() -> new AlreadyExistException(request.getEmail() + " already exist"));
    }
    //     if(user.getRole() == null || user.getRole().isBlank()){
//            user.setRole("USER");
    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with the given id " + userId));
    }

    @Override
    public User updateUser(Integer userId, User user) {
        Optional<User> optUser = userRepository.findById(userId);
        if(optUser.isPresent()){
            User existingUser  =  optUser.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(existingUser);
        }
        throw new ResourceNotFoundException("user not found");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Integer userId) {
        if(!userRepository.existsById(userId)){
            throw new ResourceNotFoundException("user not found with the given id");
        }
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserInfo(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
