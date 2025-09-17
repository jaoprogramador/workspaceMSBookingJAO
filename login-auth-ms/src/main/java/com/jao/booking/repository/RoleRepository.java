package com.jao.booking.repository;

import com.jao.booking.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
    Optional<RoleEntity> findByName(String name);
    Set<RoleEntity> findByNameIn(Set<String> names);

}
