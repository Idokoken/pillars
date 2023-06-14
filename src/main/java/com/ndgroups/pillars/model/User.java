package com.ndgroups.pillars.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min=3, message="name length must be at least 3 character")
    private String name;
    @Column(unique = true)
    @NotEmpty(message="email field should not be empty")
    @Email(regexp="(.+)@(.+)$", message="Invalid email pattern")
    private String email;
    private String salt;
//    @Pattern(regexp="[0-9]", message="Invalid mobile number")
    private String password;
    @Column(columnDefinition = "boolean default false")
    private Boolean isAdmin;

    public User() {
    }

    public User(Integer id, String name, String email,String salt, String password, Boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salt = salt;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(salt, user.salt) && Objects.equals(password, user.password) && Objects.equals(isAdmin, user.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, salt, password, isAdmin);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}