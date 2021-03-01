package com.example.minigram.controller;

import com.example.minigram.dto.SubscriptionDTO;
import com.example.minigram.model.User;
import com.example.minigram.repository.SubscriptionRepository;
import com.example.minigram.service.SubscriptionService;
import com.example.minigram.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    private final SubscriptionRepository repository;
    private final SubscriptionService service;

    public SubscriptionController (
            SubscriptionRepository repository,
            SubscriptionService service,
            UserService userService
    ) {
        this.repository = repository;
        this.service = service;
    }

//    @GetMapping
//    public List<SubscriptionDTO> findSubscriptions (Authentication authentication) {
////        Object auth = authentication.getPrincipal();
////        System.out.println(auth);
////        User user = (User) auth;
////
////        return service.getSubscriptionBySubscriber(user.getId());
//
////        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        String username = ((UserDetails) principal).getUsername();
////        User user = userService.loadUserByUsername(username);
////
////        System.out.println(principal);
////        System.out.println(user);
////
////        return service.getSubscriptionBySubscriber(user.getId());
//    }

    @PostMapping("/subscribe")     //пофиксить
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String sub (@RequestParam String subscriber, @RequestParam String subscribedTo) {
        service.save(subscriber, subscribedTo);

//        var res = repository.findAll();
//        System.out.println(res);

        return "redirect:/subscribe";
    }
}
