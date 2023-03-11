package fpt.asignment.estate_trading_system.common.repository;

import fpt.asignment.estate_trading_system.common.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    Post findByIdAndStatus(UUID id, int status);

    @Query(value = "SELECT post FROM Post post\n" +
            "        INNER JOIN Subscription sub ON post.id = sub.post.id\n" +
            "        INNER JOIN Bundle bundle ON sub.bundle.id = bundle.id\n" +
            "        INNER JOIN Users users ON post.users.id = users.id\n" +
            "        WHERE post.status = 1  AND sub.status = 1 AND sub.expiredDate > CURRENT_TIMESTAMP  AND post.id = sub.post.id AND CASE WHEN :area = -1 THEN TRUE ELSE ( post.area = :area ) END \n" +
            "        ORDER BY bundle.tier ASC, sub.price DESC, sub.startDate ASC\n")
    List<Post> findPostAdWithPagination(@Param("area") int area, Pageable pageable);
}


//SELECT * FROM post
//        INNER JOIN subscription ON post.id = subscription.post_id
//        INNER JOIN bundle ON subscription.bundle_id = bundle.id
//        WHERE post.status = 1  AND subscription.status = 1 AND UNIX_TIMESTAMP(subscription.expired_date) > UNIX_TIMESTAMP(CURRENT_TIMESTAMP())  AND post.id = subscription.post_id AND IF(-1 = -1, post.area = 30, TRUE)
//        ORDER BY bundle.tier ASC, subscription.price DESC, subscription.start_date ASC
//        LIMIT 5 OFFSET 0
//
//    SELECT post.id, post.area, post.content, post.estate_price, post.status, post.title, post.user_id  FROM post " +
//        "INNER JOIN subscription ON post.id = subscription.post_id " +
//        "INNER JOIN bundle ON subscription.bundle_id = bundle.id " +
//        "WHERE post.status = 1  AND subscription.status = 1 AND UNIX_TIMESTAMP(subscription.expired_date) > UNIX_TIMESTAMP(CURRENT_TIMESTAMP())  AND post.id = subscription.post_id AND IF(:area = -1, post.area = :area, TRUE)" +
//        "ORDER BY bundle.tier ASC, subscription.price DESC, subscription.start_date ASC " +
//        "LIMIT :limit OFFSET :offset