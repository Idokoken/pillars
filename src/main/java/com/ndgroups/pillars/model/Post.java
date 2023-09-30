package com.ndgroups.pillars.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(unique = true)
    private String title;
    private String category;
    @Column(columnDefinition = "longtext")
    private String description;
    private String author;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String imgCoverUrl;
    @Column(columnDefinition = "boolean default false")
    private Boolean isFeatured;
    @CreationTimestamp
    private LocalDateTime postDate;
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public Post() {
    }

    public Post(String title, String category, String description, String author, String imgCoverUrl,
                Boolean isFeatured, LocalDateTime postDate, LocalDateTime updatedAt) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.author = author;
        this.imgCoverUrl = imgCoverUrl;
        this.isFeatured = isFeatured;
        this.postDate = postDate;
        this.updatedAt = updatedAt;
    }
    public Post(String title, String category, String description, String author, String imgCoverUrl,
                Boolean isFeatured) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.author = author;
        this.imgCoverUrl = imgCoverUrl;
        this.isFeatured = isFeatured;
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

    public Boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
