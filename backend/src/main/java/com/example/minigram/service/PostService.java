package com.example.minigram.service;

import com.example.minigram.dto.PostDTO;
import com.example.minigram.dto.PostImageDTO;
import com.example.minigram.dto.SubscriptionDTO;
import com.example.minigram.model.Post;
import com.example.minigram.model.PostImage;
import com.example.minigram.model.User;
import com.example.minigram.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository repository;
    private final PostImageService imageService;
    private final UserService userService;
    private final SubscriptionService subscriptionService;

    public PostService (
            PostRepository repository,
            PostImageService imageService,
            UserService userService,
            SubscriptionService subscriptionService
    ) {
        this.repository = repository;
        this.imageService = imageService;
        this.userService = userService;
        this.subscriptionService = subscriptionService;
    }

    public List<PostDTO> findAll () {
        List<Post> posts = repository.findAll();

        return posts.stream().map(PostDTO::from).collect(Collectors.toList());
    }

    public List<PostDTO> findAllByPublisher (String publisherId) {
        User publisher = userService.findById(publisherId);
        List<Post> posts = repository.getAllByUserPublisher(publisher);

        return posts
                .stream()
                .map(PostDTO::from)
                .collect(Collectors.toList());
    }

    public List<PostDTO> findAllBySubscriber (String subscriberId) {
        List<PostDTO> posts = new LinkedList<>();

        List<SubscriptionDTO> subs = subscriptionService.getSubscriptionBySubscriber(subscriberId);

        subs.forEach(sub -> {
            List<PostDTO> subPosts = findAllByPublisher(sub.getSubscribedTo());

            posts.addAll(subPosts);
        });

        return posts;
    }

    public PostDTO create (PostDTO postData) {
        try {
            PostImageDTO imageDTO = imageService.findById(postData.getImageId());
            PostImage image = PostImage
                    .builder()
                    .id(imageDTO.getId())
                    .imageData(imageDTO.getData())
                    .build();

            User user = userService.findById(postData.getPublishedBy());

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
