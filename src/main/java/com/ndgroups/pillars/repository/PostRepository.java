package com.ndgroups.pillars.repository;

import com.ndgroups.pillars.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    public List<Post> findByCategory(String category);
    public List<Post> findByTitle(String title);
//    public List<Post> findByFeatured(Boolean isFeatured);

}
