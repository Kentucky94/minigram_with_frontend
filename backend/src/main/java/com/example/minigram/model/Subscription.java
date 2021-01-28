package com.example.minigram.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@Table(
        name = "subscriptions",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"subscriber", "subscribedTo"}) }
)
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
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
