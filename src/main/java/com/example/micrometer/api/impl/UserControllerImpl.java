package com.example.micrometer.api.impl;

import com.example.micrometer.api.interfaces.UserController;
import com.example.micrometer.api.models.response.SpUserJson;
import com.example.micrometer.api.models.response.UserCertificateJson;
import com.example.micrometer.dto.SignPlatformUser;
import com.example.micrometer.mapper.UserCertificateMapper;
import com.example.micrometer.mapper.UserMapper;
import com.example.micrometer.services.interfaces.UserService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
//    @Timed(value = "users.info")
    public SpUserJson getUserInfo(@RequestBody SignPlatformUser principal) {
        return UserMapper.MAPPER.toSpUserShared(userService.getUserInfo(principal));
    }

    @Override
//    @Timed(value = "users.certificates")
    public List<UserCertificateJson> getUserCertificates(@RequestBody SignPlatformUser principal) {
        return userService.getUserCertificates(principal).stream()
            .map(UserCertificateMapper.MAPPER::map)
            .collect(Collectors.toList());
    }

}
