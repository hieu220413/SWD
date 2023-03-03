package fpt.asignment.estate_trading_system.common.repository;

import fpt.asignment.estate_trading_system.common.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {
    @Query(value = "SELECT * FROM wallet WHERE BIN_TO_UUID(user_id) = :userId AND status = 1" ,nativeQuery = true)
    Wallet findByUserId(@Param("userId") String userId);
}
