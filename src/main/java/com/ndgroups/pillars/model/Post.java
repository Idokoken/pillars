package com.ndgroups.pillars.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String title;
    private String category;
    private String description;
    private String author;
    private String imgCoverUrl;
    private LocalDateTime postDate;

    public Post() {
    }

    public Post(Integer postIdd, String title, String category, String description, String author, String imgCoverUrl, LocalDateTime postDate) {
        this.postId = postIdd;
        this.title = title;
        this.category = category;
        this.description = description;
        this.author = author;
        this.imgCoverUrl = imgCoverUrl;
        this.postDate = postDate;
    }

    public Integer getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgCoverUrl() {
        return imgCoverUrl;
    }

    public void setImgCoverUrl(String imgCoverUrl) {
        this.imgCoverUrl = imgCoverUrl;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) && Objects.equals(title, post.title) && Objects.equals(category, post.category) && Objects.equals(description, post.description) && Objects.equals(author, post.author) && Objects.equals(imgCoverUrl, post.imgCoverUrl) && Objects.equals(postDate, post.postDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, title, category, description, author, imgCoverUrl, postDate);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + postId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", imgCoverUrl='" + imgCoverUrl + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}
