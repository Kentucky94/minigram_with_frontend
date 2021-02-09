package com.example.minigram.repository;

import com.example.minigram.model.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PostImageRepository extends JpaRepository<PostImage, String> {
}
