package com.example.minigram.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
@Entity
@Table(name = "users")
public class User {
    public static final User EMPTY = new User("test", "test", "test");

    public User (String name, String pass, String email) {
        this.username = name;
        this.password = "test";
        this.email = "test";
        this.id = -123;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private int postsCount = 0;

    @Column
    private int subscriptionsCount = 0;

    @Column
    private int subscribersCount = 0;

    @OneToMany(mappedBy = "userPublisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @OneToMany(mappedBy = "userCommenter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comments> comments;

    @OneToMany(mappedBy = "userLiked", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes;

    @OneToMany(mappedBy = "userSubscriber", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subscription> subscribers;

    @OneToMany(mappedBy = "userSubscribedTo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subscription> subscribedTo;

}
