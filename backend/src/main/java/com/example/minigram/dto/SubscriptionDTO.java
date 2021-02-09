package com.example.minigram.dto;

import com.example.minigram.model.Subscription;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SubscriptionDTO {
    public static SubscriptionDTO from (Subscription subscription) {
        return builder()
                .id(subscription.getId())
                .subscriberId(subscription.getUserSubscriber().getId())
                .subscribedTo(subscription.getUserSubscribedTo().getId())
                .build();
    }

    private String id;
    private String subscriberId;
    private String subscribedTo;
}
