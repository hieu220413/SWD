package fpt.asignment.estate_trading_system.common.repository;

import fpt.asignment.estate_trading_system.common.entity.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BundleRepository extends JpaRepository<Bundle, UUID> {
    Bundle findByIdAndStatus(UUID id, int status);
}
