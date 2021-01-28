package com.example.minigram.service;

import com.example.minigram.model.Subscription;
import com.example.minigram.model.User;
import com.example.minigram.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository repository;
    @Autowired
    private UserService userService;

    public void save (String subscriberId, String subscribedToId) {
        User subscriber = userService.findById(Integer.parseInt(subscriberId));

        User subscribedTo = userService.findById(Integer.parseInt(subscribedToId));

        Subscription subscription = new Subscription();
        subscription.setUserSubscriber(subscriber);
        subscription.setUserSubscribedTo(subscribedTo);

        repository.save(subscription);
    }
}
