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
                : post.getUserPublisher().getId();

        return builder()
                .id(post.getId())
                .description(post.getDescription())
                .datetime(post.getDatetime())
                .publishedBy(publisher)
                .imageId(post.getImage().getId())
                .build();
    }

    private String id;
    private String description;
    private String imageId;
    private LocalDateTime datetime;
    private String publishedBy;
}
