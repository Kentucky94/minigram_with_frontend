package com.example.minigram.controller;

import com.example.minigram.dto.PostImageDTO;
import com.example.minigram.repository.PostImageRepository;
import com.example.minigram.service.PostImageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/postImages")
public class PostImageController {
    private final PostImageRepository repository;
    private final PostImageService service;

    public PostImageController (PostImageRepository repository, PostImageService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping(value = "/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getById (@PathVariable String imageId) {
        return service.findById(imageId).getData();
    }

    @PostMapping("/upload")
    public PostImageDTO upload (@RequestParam("file") MultipartFile file) {
        return service.upload(file);
    }
}
