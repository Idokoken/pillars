package com.ndgroups.pillars.repository;

import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
