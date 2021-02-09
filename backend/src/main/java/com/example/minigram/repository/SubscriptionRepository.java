package com.example.minigram.repository;

import com.example.minigram.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {

}
