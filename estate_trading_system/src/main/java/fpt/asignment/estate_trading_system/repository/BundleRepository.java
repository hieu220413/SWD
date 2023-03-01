package fpt.asignment.estate_trading_system.repository;

import fpt.asignment.estate_trading_system.entity.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BundleRepository extends JpaRepository<Bundle, UUID> {
    Bundle findByIdAndStatus(UUID id, int status);
}
