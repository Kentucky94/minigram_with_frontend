package com.example.minigram.model;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Entity
@Table(name = "postImages")
@Builder
public class PostImage {
    public static final PostImage EMPTY = builder().build();

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Column
    @Builder.Default
    private byte[] imageData = new byte[0];

    @OneToOne(mappedBy = "image")
    private Post post;

    @Override
    public String toString() {
        return "PostImage{" +
                "id='" + id + '\'' +
                Arrays.toString(imageData) +
                '}';
    }
}
