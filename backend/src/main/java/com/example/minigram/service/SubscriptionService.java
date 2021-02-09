package com.example.minigram.service;

import com.example.minigram.dto.SubscriptionDTO;
import com.example.minigram.model.Subscription;
import com.example.minigram.model.User;
import com.example.minigram.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {
    private final SubscriptionRepository repository;
    private final UserService userService;

    public SubscriptionService (SubscriptionRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public List<SubscriptionDTO> getSubscriptionBySubscriber (String subscriberId) {
        User subscriber = userService.findById(subscriberId);
        List<Subscription> subs = repository.getAllByUserSubscriber(subscriber);

        return subs
                .stream()
                .map(SubscriptionDTO::from)
                .collect(Collectors.toList());
    }

    public void save (String subscriberId, String subscribedToId) {
        User subscriber = userService.findById(subscriberId);

        User subscribedTo = userService.findById(subscribedToId);

        Subscription subscription = new Subscription();
        subscription.setUserSubscriber(subscriber);
        subscription.setUserSubscribedTo(subscribedTo);

        repository.save(subscription);
    }
}
