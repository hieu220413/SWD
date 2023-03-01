package fpt.asignment.estate_trading_system.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface SubscriptionService {
    ResponseEntity<Map<String, String>> purchaseSubscription(String postId, String bundleId, String encodeAuthor, Long price);
}
