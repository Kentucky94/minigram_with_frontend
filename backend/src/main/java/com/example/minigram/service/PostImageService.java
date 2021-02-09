package com.example.minigram.service;

import com.example.minigram.dto.PostImageDTO;
import com.example.minigram.model.Post;
import com.example.minigram.model.PostImage;
import com.example.minigram.repository.PostImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PostImageService {
    private final PostImageRepository repository;

    public PostImageService (PostImageRepository repository) {
        this.repository = repository;
    }

    public PostImageDTO findById (String imageId) {
        PostImage image =  repository
            .findById(imageId)
            .orElse(PostImage.EMPTY);

        return PostImageDTO.from(image);
    }

    public PostImageDTO upload (MultipartFile file) {
        try {
            byte[] bytes = new byte[0];

            try {
                bytes = file.getBytes();
            } catch (Exception e) {
                e.printStackTrace();
            }

            PostImage image = PostImage.builder().imageData(bytes).build();
            repository.save(image);

            return PostImageDTO.from(image);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return PostImageDTO.from(PostImage.EMPTY);
    }
}
