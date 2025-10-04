package com.ndgroups.pillars.repository;

import com.ndgroups.pillars.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
    List<User> findByUsername(String username);
    boolean existsByEmail(String email);
}
