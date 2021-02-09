package com.example.minigram.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@Table(name = "posts")
@Builder
public class Post {
    public static final Post EMPTY = builder().description("fake_descr").userPublisher(User.EMPTY).build();

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image")
    @Builder.Default
    private PostImage image = PostImage.EMPTY;

    @Column(nullable = false)
    private String description;

    @Column
    @Builder.Default
    private LocalDateTime datetime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User userPublisher;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", image='" + image.getId() + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", userPublisher=" + userPublisher.getId() +
                '}';
    }
}
