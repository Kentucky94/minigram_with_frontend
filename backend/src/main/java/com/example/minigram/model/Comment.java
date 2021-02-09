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
@Table(name = "comments")
@Builder
public class Comment {
    private static final Comment EMPTY = builder().text("testComment").userCommenter(User.EMPTY).build();

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String text;

    @Column
    @Builder.Default
    private LocalDateTime datetime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User userCommenter;

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", datetime=" + datetime +
                ", userCommenter=" + userCommenter.getId() +
                '}';
    }
}
