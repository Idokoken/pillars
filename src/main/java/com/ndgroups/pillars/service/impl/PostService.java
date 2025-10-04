package com.ndgroups.pillars.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private Cloudinary cloudinary;

    public Post createPost(MultipartFile file, String title, String category, String description, String author,
                           Boolean isFeatured) {
        Post post  = new Post();
        try {
            try {
            String imgCover  =  cloudinary.uploader()
                    .upload(file.getBytes(), ObjectUtils.asMap("folder", "pillars"))
                    .get("url")
                    .toString();

            post.setImgCoverUrl(imgCover);
        }catch (IOException e) {
            e.printStackTrace();
         }

            post.setTitle(title);
            post.setCategory(category);
            post.setDescription(description);
            post.setAuthor(author);
            post.setIsFeatured(isFeatured);

            Post newPost = postRepository.save(post);
            return newPost;
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateKeyException("a duplicate entry was found for the unique key");
        }
    }

    public Post updatePost(Integer id, MultipartFile file, String title, String category, String description, String author,
                           Boolean isFeatured) throws IOException {
        Optional<Post> optPost = postRepository.findById(id);
        Post existingPost  = optPost.get();
//                            .orElseThrow(() -> new EntityNotFoundException("entity not found"));

            existingPost.setTitle(title);
            existingPost.setCategory(category);
            existingPost.setDescription(description);
            existingPost.setAuthor(author);
            existingPost.setIsFeatured(isFeatured);

            if(file != null && !file.isEmpty()) {
                String imgCover  =  cloudinary.uploader()
                        .upload(file.getBytes(), ObjectUtils.asMap("folder", "pillars"))
                        .get("url")
                        .toString();

                existingPost.setImgCoverUrl(imgCover);
            }

            return postRepository.save(existingPost);
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
    public Optional<Post> getOnePost(Integer id) {
        return postRepository.findById(id);
    }
    public Page<Post> getPostPage(Pageable pageable){
//        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<Post> postPages = postRepository.getPagePost(pageable);
        return postPages;
    }
    public Page<Post> searchPost(String keyword, Pageable pageable) {
        Page<Post> searchedPost  = postRepository.searchPost(keyword, pageable);
        return searchedPost;
    }
    public Page<Post> getPostByCategory(String category, Pageable pageable) {
        Page<Post> postCategory = postRepository.findByCategory(category, pageable);
        return postCategory;
    }
    public List<Post> getFeaturedPost( int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Post> featuredPost = postRepository.findByIsFeaturedTrueOrderByPostDateDesc(pageable);
        return featuredPost;
    }
    public List<Post> getLatestPost(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Post> latestPost = postRepository.findByIsFeaturedFalseOrderByPostDateDesc(pageable);
        return latestPost;
    }

//delete Post
public void delPost(Integer id){
    Optional<Post> optPost  = postRepository.findById(id);
    System.out.println(optPost.get().getImgCoverUrl());
    try {
        cloudinary.uploader().destroy(optPost.get().getImgCoverUrl(), ObjectUtils.emptyMap());
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    postRepository.delete(optPost.get());
}
    public String uploadFile(MultipartFile file) throws IOException {
//        String imgCover  =  cloudinary.uploader()
//                            .upload(file.getBytes(), Map.of("public_id", UUID.randomUUID().toString()))
//                            .get("url")
//                            .toString();
        String imgCover  =  cloudinary.uploader()
                .upload(file.getBytes(), ObjectUtils.asMap("folder", "pillars"))
                .get("url")
                .toString();
        return imgCover;
    }




}

