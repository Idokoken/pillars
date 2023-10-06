package com.ndgroups.pillars.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Util;
import com.cloudinary.utils.ObjectUtils;
import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.repository.PostRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private Cloudinary cloudinary;

//    Dotenv dotenv = Dotenv.load();
//    Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));
//    cloudinary.config.secure = true;


    public Post createPost(MultipartFile file, String title, String category, String description, String author,
                           Boolean isFeatured) {
        Post post  = new Post();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

//        convert image file file base64 string
//        byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
//        String encodedString = Base64.getEncoder().encodeToString(fileContent);
//        convert base64 string to image file
        if (fileName.contains("..")){
            System.out.println("not a valid file");
        }
        try {
            post.setImgCoverUrl(Base64.getEncoder().encodeToString(file.getBytes()));
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
                existingPost.setImgCoverUrl(Base64.getEncoder().encodeToString(file.getBytes()));
            }

            return postRepository.save(existingPost);
    }

//    public Post createPost(Post post) {
//        return postRepository.save(post);
  //  }
//public Optional<Post updatePost(Post post) {
//    Optional<Post> optPost = postRepository.findById(post.getPostId());
//    if(optPost.isPresent()){
//
//
//        Post existingPost  = optPost.get();
//
//        existingPost.setImgCoverUrl(Base64.getEncoder().encodeToString(post.getImgCoverUrl().getBytes()));
//        existingPost.setTitle(post.getTitle());
//        existingPost.setCategory(post.getCategory());
//        existingPost.setDescription(post.getDescription());
//        existingPost.setAuthor(post.getAuthor());
//        existingPost.setImgCoverUrl(post.getImgCoverUrl());
//        existingPost.setIsFeatured(post.getIsFeatured());
//
//        postRepository.save(existingPost);
//
//        return Optional.of(existingPost);
//    }
//    return Optional.empty();
//}



    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
    public Optional<Post> getOnePost(Integer id) {
        return postRepository.findById(id);
    }
    public List<Post> findByCriteria(String criteria, String searchItem) {
        if(criteria == "category") {
            return postRepository.findByCategory(searchItem);
        }
        if(criteria == "title") {
            return postRepository.findByTitle(searchItem);
        }
       return new ArrayList<>();
    }



//working with cloudinary
//    create post
//    public Post createPost(MultipartFile file, String title, String category, String description, String author,
//                              Boolean isFeatured) {
//        Post post  = new Post();
//        try {
//            String imgCover  =  cloudinary.uploader()
//                    .upload(file.getBytes(), ObjectUtils.asMap("folder", "pillars"))
//                    .get("url")
//                    .toString();
//
//            post.setImgCoverUrl(imgCover);
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//        post.setTitle(title);
//        post.setCategory(category);
//        post.setDescription(description);
//        post.setAuthor(author);
//        post.setIsFeatured(isFeatured);
//
//        Post newPost = postRepository.save(post);
//        return newPost;
//    }
//update post


//delete Post
public void delPost(Integer id){
    Optional<Post> optPost  = postRepository.findById(id);
 //   cloudinary.uploader().destroy(optPost.get().getImgCoverUrl(), ObjectUtils.asMap("folder", "pillars"));
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

