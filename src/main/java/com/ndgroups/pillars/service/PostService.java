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

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
    public Optional<Post> getOnePost(Integer id) {
        return postRepository.findById(id);
    }
    public List<Post> findByCategory(String category) {
        return postRepository.findByCategory(category);
    }
    public Optional<Post> updatePost(Post post) {
        Optional<Post> optPost = postRepository.findById(post.getPostId());
        if(optPost.isPresent()){
            Post existingPost  = optPost.get();
            existingPost.setTitle(post.getTitle());
            existingPost.setCategory(post.getCategory());
            existingPost.setDescription(post.getDescription());
            existingPost.setAuthor(post.getAuthor());
            existingPost.setImgCoverUrl(post.getImgCoverUrl());
            existingPost.setIsFeatured(post.getIsFeatured());

            postRepository.save(existingPost);

            return Optional.of(existingPost);
        }
        return Optional.empty();
    }
    public void delPost(Integer id){
       Optional<Post> optPost  = postRepository.findById(id);
       postRepository.delete(optPost.get());
    }
}

