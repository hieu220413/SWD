package fpt.asignment.estate_trading_system.repository;

import fpt.asignment.estate_trading_system.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    Users findByUsername(String username);
    Users findByUsernameAndStatus(String username, int status);
    Users findByIdAndStatus(UUID id, int status);
}
