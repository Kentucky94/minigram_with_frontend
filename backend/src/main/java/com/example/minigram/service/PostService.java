package com.example.minigram.service;

import com.example.minigram.dto.PostDTO;
import com.example.minigram.model.Post;
import com.example.minigram.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService (PostRepository repository) {
        this.repository = repository;
    }

    public List<PostDTO> findAll () {
        List<Post> posts = repository.findAll();

        return posts.stream().map(PostDTO::from).collect(Collectors.toList());
    }
}
