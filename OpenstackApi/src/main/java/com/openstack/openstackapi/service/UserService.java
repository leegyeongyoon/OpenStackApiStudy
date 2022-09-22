package com.openstack.openstackapi.service;

import com.openstack.openstackapi.entity.UserEntity;
import com.openstack.openstackapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
}
