package com.example.minigram.repository;

import com.example.minigram.model.Subscription;
import com.example.minigram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {
    public List<Subscription> getAllByUserSubscriber (User subscriber);
}
