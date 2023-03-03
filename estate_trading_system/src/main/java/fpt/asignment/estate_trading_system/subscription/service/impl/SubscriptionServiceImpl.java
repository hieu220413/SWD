package fpt.asignment.estate_trading_system.subscription.service.impl;

import fpt.asignment.estate_trading_system.common.entity.*;
import fpt.asignment.estate_trading_system.common.exception.*;
import fpt.asignment.estate_trading_system.common.repository.*;
import fpt.asignment.estate_trading_system.entity.*;
import fpt.asignment.estate_trading_system.exception.*;
import fpt.asignment.estate_trading_system.repository.*;
import fpt.asignment.estate_trading_system.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    @Autowired
    WalletRepository walletRepository;

    @Override
    public ResponseEntity<Map<String, String>> purchaseSubscription(String postId, String bundleId, String encodeAuthor, Long price) {
        byte[] credDecoded = Base64.getDecoder().decode(encodeAuthor.substring("Basic".length()).trim());
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);
        String username = credentials.split(":",2)[0];

        Post postEntity = postRepository.findByIdAndStatus(UUID.fromString(postId), 1);
        Bundle bundleEntity = bundleRepository.findByIdAndStatus(UUID.fromString(bundleId), 1);
        Users userEntity = userRepository.findByUsernameAndStatus(username, 1);

        if(userEntity == null)
            throw new UserNotFoundException("User not found");
        if(bundleEntity == null)
            throw new BundleNotFoundException("Bundle not found");
        if(postEntity == null)
            throw new PostNotFoundException("Post not found");
        if(postEntity.getUsers().getId() != userEntity.getId())
            throw new PostAuthorInvalidException("This user is not the author of the post");
        if(subscriptionRepository.findExistedPostSubscription(postEntity.getId().toString()) != null)
            throw new SubscriptionForPostForbiddenException("Post already had an active subscription");
        if(price > bundleEntity.getMaxPrice() || price < bundleEntity.getMinPrice())
            throw new OutOfRangePriceException("Price must be equal or higher than min price of bundle and be equal or lower than max price of bundle");
        if(bundleEntity.getAvailableQuantity() == 0)
            throw new OutofSlotBundleException("Bundle is not available");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);


        Subscription subscription = new Subscription(userEntity, postEntity, bundleEntity, price, Timestamp.valueOf(tomorrow), Timestamp.valueOf(now), (byte) 1);
        subscriptionRepository.save(subscription);
        bundleEntity.setAvailableQuantity(bundleEntity.getAvailableQuantity()-1);
        bundleRepository.save(bundleEntity);
        Wallet wallet = walletRepository.findByUserId(userEntity.getId().toString());
        wallet.setBalance((wallet.getBalance()-price));
        walletRepository.save(wallet);
        Map<String, String> successMesssage = new HashMap<>();
        successMesssage.put("message", "add subscription successfully");
        return ResponseEntity.status(HttpStatus.OK.value()).body(successMesssage);
    }
}
