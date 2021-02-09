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

    public PostImage findById (String imageId) throws Exception {
        return repository
            .findById(imageId)
            .orElseThrow(() -> new Exception("Image was not found"));
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
            System.out.println(image);
            repository.save(image);

            System.out.println(image.getId());

            return PostImageDTO.from(image);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return PostImageDTO.from(PostImage.EMPTY);
    }
}
