package com.example.minigram.controller;

import com.example.minigram.repository.SubscriptionRepository;
import com.example.minigram.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SubscriptionController {
    private final SubscriptionRepository repository;
    private final SubscriptionService service;

    public SubscriptionController (SubscriptionRepository repository, SubscriptionService service) {
        this.repository = repository;
        this.service = service;
    }

//    @GetMapping
//    public String root () {
//        return "subscribe";
//    }
//
//    @GetMapping("/subscribe")
//    public String example () {
//
//        return "subscribe";
//    }
//
//    @PostMapping("/subscribe")
//    @ResponseStatus(HttpStatus.SEE_OTHER)
//    public String sub (@RequestParam String subscriber, @RequestParam String subscribedTo) {
//        service.save(subscriber, subscribedTo);
//
////        var res = repository.findAll();
////        System.out.println(res);
//
//        return "redirect:/subscribe";
//    }
}
