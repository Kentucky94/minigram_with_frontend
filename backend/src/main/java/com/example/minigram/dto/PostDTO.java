package com.example.minigram.dto;

import com.example.minigram.model.Post;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class PostDTO {
    public static PostDTO from (Post post) {
        String publisher = post.getUserPublisher() == null
                ? "not-found"
                : post.getUserPublisher().getUsername();

        return builder()
                .id(post.getId())
                .description(post.getDescription())
                .image(post.getImage())
                .datetime(post.getDatetime())
                .publishedBy(publisher)
                .build();
    }

    private Integer id;
    private String description;
    private String image;
    private LocalDateTime datetime;
    private String publishedBy;
}
