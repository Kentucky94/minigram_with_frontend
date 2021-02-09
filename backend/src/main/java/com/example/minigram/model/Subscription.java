package com.example.minigram.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@Table(
        name = "subscriptions",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"subscriber", "subscribedTo"}) }
)
@Builder
public class Subscription {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Column
    @Builder.Default
    private LocalDateTime datetime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriber")
    private User userSubscriber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscribedTo")
    private User userSubscribedTo;

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", userSubscriber=" + userSubscriber.getId() +
                ", userSubscribedTo=" + userSubscribedTo.getId() +
                '}';
    }
}
