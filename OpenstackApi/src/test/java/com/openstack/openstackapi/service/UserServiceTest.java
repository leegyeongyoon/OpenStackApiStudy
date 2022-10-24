package com.openstack.openstackapi.service;

import com.openstack.openstackapi.entity.UserEntity;
import com.openstack.openstackapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void joinUser11(){
        Map<String,String> user = new HashMap<>();
        UserEntity member1 = UserEntity.builder()
                .userId("id1")
                .username("leegy")
                .password("pw1")
                .build();
        ;
        given(userRepository.findByUserId("id1")).willReturn(Optional.of(member1));

        user.put("userId", "id1");
        user.put("password", "password1");
        user.put("username", "leegy");
        Optional<UserEntity> userTest = userService.joinUser(user);
        assertEquals("id1", userTest.get().getUserId());
    }
}

