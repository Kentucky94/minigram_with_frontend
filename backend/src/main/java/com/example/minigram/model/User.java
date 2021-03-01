package com.example.minigram.model;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@Table(name = "users")
@Builder
public class User {
    public static final User EMPTY = builder().username("test").email("test").password("test").build();

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    @Builder.Default
    private int postsCount = 0;

    @Column
    @Builder.Default
    private int subscriptionsCount = 0;

    @Column
    @Builder.Default
    private int subscribersCount = 0;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    @Builder.Default
//    private UserRole role = UserRole.ROLE_READER;

    @Column(nullable = false)
    @Builder.Default
    private String roles = "ROLE_USER";

    @Column
    @Builder.Default
    private boolean active = true;

    @OneToMany(mappedBy = "userPublisher", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Post> posts = new LinkedList<>();

    @OneToMany(mappedBy = "userCommenter", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Comment> comments = new LinkedList<>();

    @OneToMany(mappedBy = "userLiked", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Like> likes = new LinkedList<>();

    @OneToMany(mappedBy = "userSubscriber", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Subscription> subscribers = new LinkedList<>();

    @OneToMany(mappedBy = "userSubscribedTo", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Subscription> subscribedTo = new LinkedList<>();

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", postsCount=" + postsCount +
                ", subscriptionsCount=" + subscriptionsCount +
                ", subscribersCount=" + subscribersCount +
                '}';
    }
}
