package com.openstack.openstackapi.controller;

import com.openstack.openstackapi.entity.UserEntity;
import com.openstack.openstackapi.repository.UserRepository;
import com.openstack.openstackapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Optional<UserEntity> join(@RequestBody Map<String, String> user) {
        return userService.joinUser(user);
    }
}
