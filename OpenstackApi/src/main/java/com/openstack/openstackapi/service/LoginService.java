package com.openstack.openstackapi.service;

import com.openstack.openstackapi.entity.UserEntity;
import com.openstack.openstackapi.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public Optional<UserEntity> userLogin(Map<String,String> userParam) {
        String userId = userParam.get("userId");
        String userPassword = userParam.get("password");
        return loginRepository.findByUserIdAndPassword(userId,userPassword);
    }
}
