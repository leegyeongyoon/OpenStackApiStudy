package com.openstack.openstackapi.controller;

import com.openstack.openstackapi.config.jwt.JwtTokenProvider;
import com.openstack.openstackapi.entity.UserEntity;
import com.openstack.openstackapi.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class LoginRestController {
    private final LoginService loginService;
    private final JwtTokenProvider jwtTokenProvider;

    @CrossOrigin("*")
    @PostMapping("/user/login")
    private String login(@RequestBody Map<String, String> userParam) {
        Optional<UserEntity> userLogin = loginService.userLogin(userParam);
        if (loginService.userLogin(userParam).isPresent()) {
            return jwtTokenProvider.createToken(userLogin.get().getUserId(), userLogin.get().getRoles());
        }
        return "아이디 혹은 비밀번호가 없습니다.";
    }
}
