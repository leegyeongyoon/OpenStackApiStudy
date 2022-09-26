package com.openstack.openstackapi.repository;

import com.openstack.openstackapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserIdAndPassword(String userId, String password);
}
