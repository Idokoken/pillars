package com.ndgroups.pillars.service;

import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }
    public Optional<Post> getOnePost(Integer id) {
        return postRepository.findById(id);
    }
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
}
