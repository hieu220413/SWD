package fpt.asignment.estate_trading_system.service.impl;

import fpt.asignment.estate_trading_system.entity.Bundle;
import fpt.asignment.estate_trading_system.entity.Post;
import fpt.asignment.estate_trading_system.entity.Subscription;
import fpt.asignment.estate_trading_system.entity.Users;
import fpt.asignment.estate_trading_system.repository.BundleRepository;
import fpt.asignment.estate_trading_system.repository.PostRepository;
import fpt.asignment.estate_trading_system.repository.SubscriptionRepository;
import fpt.asignment.estate_trading_system.repository.UserRepository;
import fpt.asignment.estate_trading_system.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    BundleRepository bundleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public ResponseEntity<Map<String, String>> purchaseSubscription(String postId, String bundleId, String encodeAuthor, Long price) {
        byte[] credDecoded = Base64.getDecoder().decode(encodeAuthor.substring("Basic".length()).trim());
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);
        String username = credentials.split(":",2)[0];

        Post postEntity = postRepository.findByIdAndStatus(UUID.fromString(postId), 1);
        Bundle bundleEntity = bundleRepository.findByIdAndStatus(UUID.fromString(bundleId), 1);
        Users userEntity = userRepository.findByUsernameAndStatus(username, 1);

        if(userEntity == null)
            throw new UserNotFoundException();
        if(bundleEntity == null)
            throw new BundleNotFoundException();
        if(postEntity == null)
            throw new PostNotFoundException();
        if(price > bundleEntity.getMaxPrice() || price < bundleEntity.getMinPrice())
            throw new OutOfRangePriceException();
        if(bundleEntity.getAvailableQuantity() == 0)
            throw new OutofSlotBundleException();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);


        Subscription subscription = new Subscription(userEntity, postEntity, bundleEntity, price, Timestamp.valueOf(tomorrow), Timestamp.valueOf(now), (byte) 1);
        subscriptionRepository.save(subscription);
        Map<String, String> successMesssage = new HashMap<>();
        successMesssage.put("message", "add subscription successfully");
        return ResponseEntity.status(HttpStatus.OK.value()).body(successMesssage);
    }
}
