package com.jao.booking.repository;

import com.jao.booking.entity.PasswordHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PasswordHistoryRepository extends JpaRepository<PasswordHistoryEntity, UUID> {
    List<PasswordHistoryEntity> findByUserId(UUID userId);
}

