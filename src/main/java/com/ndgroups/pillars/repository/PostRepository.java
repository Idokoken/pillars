package com.ndgroups.pillars.repository;

import com.ndgroups.pillars.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
//    @Query("select p from Post p where p.category")
    public Page<Post> findByCategory(String category, Pageable pageable);
    public List<Post> findByTitle(String title);
    @Query("select p from Post p")
    public Page<Post> getPagePost(Pageable pageable);

    @Query("select p from Post p where p.title like %?1% or p.category like %?1%")
    public Page<Post>searchPost(String keyword, Pageable pageable);
//    @Query("select p from Post p where p.isFeatured")
//    public Page<Post> findByFeatured(Pageable pageable);

}
