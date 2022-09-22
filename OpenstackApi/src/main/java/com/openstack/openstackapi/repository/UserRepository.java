package com.openstack.openstackapi.repository;

import com.openstack.openstackapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserId(String userId);

    List<UserEntity> findAll(String userId);
}
