package com.example.minigram.controller;

import com.example.minigram.dto.PostDTO;
import com.example.minigram.repository.PostRepository;
import com.example.minigram.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
