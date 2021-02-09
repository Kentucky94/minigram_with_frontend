package com.example.minigram.repository;

import com.example.minigram.model.Post;
import com.example.minigram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, String> {
    public List<Post> getAllByUserPublisher (User publisher);
}
