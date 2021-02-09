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
@Table(name = "likes")
@Builder
public class Like {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Column
    @Builder.Default
    private LocalDateTime datetime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User userLiked;

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", userLiked=" + userLiked.getId() +
                '}';
    }
}
