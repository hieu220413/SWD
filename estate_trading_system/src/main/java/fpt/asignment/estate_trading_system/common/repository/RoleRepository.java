package fpt.asignment.estate_trading_system.common.repository;

import fpt.asignment.estate_trading_system.common.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByName(String name);
}
