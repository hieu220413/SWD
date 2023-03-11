package fpt.asignment.estate_trading_system.common.repository;

import fpt.asignment.estate_trading_system.common.entity.Subscription;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {
    @Query(value = "SELECT * FROM subscription WHERE BIN_TO_UUID(post_id) = :postId AND status = 1 LIMIT 1" ,nativeQuery = true)
    Subscription findExistedPostSubscription(@Param("postId") String postId);
}
