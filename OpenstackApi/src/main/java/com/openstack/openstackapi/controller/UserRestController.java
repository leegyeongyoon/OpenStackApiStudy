package com.openstack.openstackapi.controller;

import com.openstack.openstackapi.entity.UserEntity;
import com.openstack.openstackapi.repository.UserRepository;
import com.openstack.openstackapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserRestController {
    private final UserService userService;
    private final UserRepository userRepository;

    @CrossOrigin("*")
    @PostMapping("/user/userList")
    private List<UserEntity> userList() {
        return userService.findAll();
    }

    @PostMapping("/user/join")
    public String join(@RequestBody Map<String, String> user) {
        return userRepository.save(UserEntity.builder()
                .userId(user.get("userId"))
                .password(user.get("password"))
                .username(user.get("username"))
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build()).getUserId();
    }
}
