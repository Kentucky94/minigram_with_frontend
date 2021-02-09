package com.example.minigram.service;

import com.example.minigram.dto.PostDTO;
import com.example.minigram.dto.PostImageDTO;
import com.example.minigram.model.Post;
import com.example.minigram.model.PostImage;
import com.example.minigram.model.User;
import com.example.minigram.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository repository;
    private final PostImageService imageService;
    private final UserService userService;

    public PostService (PostRepository repository, PostImageService imageService, UserService userService) {
        this.repository = repository;
        this.imageService = imageService;
        this.userService = userService;
    }

    public List<PostDTO> findAll () {
        List<Post> posts = repository.findAll();

        return posts.stream().map(PostDTO::from).collect(Collectors.toList());
    }

    public PostDTO create (PostDTO postData) {
        try {
            PostImage image = imageService.findById(postData.getImageId());
            User user = userService.findById(postData.getPublishedBy());
            System.out.println(user);

            Post post = Post
                    .builder()
                    .description(postData.getDescription())
                    .image(image)
                    .userPublisher(user)
                    .build();

            repository.save(post);

            return PostDTO.from(post);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return PostDTO.from(Post.EMPTY);
    }
}
