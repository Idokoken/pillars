package com.ndgroups.pillars.service.Interface;

import com.ndgroups.pillars.Request.CreateUserRequest;
import com.ndgroups.pillars.model.User;

import java.util.List;

public interface IUserService {
    User createUser(CreateUserRequest request);
    User getUserById(Integer userId);
    User updateUser(Integer userId, User user);
    void deleteUser(Integer userId);
    List<User> getAllUsers();
    User getUserInfo(String email);
    List<User> findByUsername(String username);
}
