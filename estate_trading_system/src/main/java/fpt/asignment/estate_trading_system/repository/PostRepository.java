package fpt.asignment.estate_trading_system.repository;

import fpt.asignment.estate_trading_system.entity.Bundle;
import fpt.asignment.estate_trading_system.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    Post findByIdAndStatus(UUID id, int status);
}
