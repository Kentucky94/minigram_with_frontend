package com.example.minigram.dto;

import com.example.minigram.model.PostImage;
import lombok.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class PostImageDTO {
    public static PostImageDTO from (PostImage image) {
        return builder()
                .id(image.getId())
                .data(image.getImageData())
                .build();
    }

    private String id;

    @Builder.Default
    byte[] data = new byte[0];
}
