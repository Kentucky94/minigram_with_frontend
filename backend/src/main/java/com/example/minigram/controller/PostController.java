package com.example.minigram.controller;

import com.example.minigram.dto.PostDTO;
import com.example.minigram.dto.PostImageDTO;
import com.example.minigram.repository.PostRepository;
import com.example.minigram.service.PostService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostRepository repository;
    private final PostService service;

    public PostController (PostRepository repository, PostService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    private List<PostDTO> getAll () {
        return service.findAll();
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    private PostDTO addPost (@RequestBody PostDTO postData) {
        return service.create(postData);
    }
}
