package com.openstack.openstackapi.controller;

import com.openstack.openstackapi.entity.UserEntity;
import com.openstack.openstackapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserRestController {
    private final UserService userService;

    @CrossOrigin("*")
    @GetMapping("/admin/userList")
    private List<UserEntity> userList() {
        return userService.findAll();
    }
}
