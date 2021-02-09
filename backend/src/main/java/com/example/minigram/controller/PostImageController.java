package com.example.minigram.controller;

import com.example.minigram.dto.PostImageDTO;
import com.example.minigram.repository.PostImageRepository;
import com.example.minigram.service.PostImageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/upload")
    private PostImageDTO upload (@RequestParam("file") MultipartFile file) {
        return service.upload(file);
    }
}
