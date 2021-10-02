package com.example.micrometer.services.impl;

import com.example.micrometer.dto.SignPlatformUser;
import com.example.micrometer.dto.SpUserDto;
import com.example.micrometer.dto.UserCertificateDto;
import com.example.micrometer.services.dao.UsrApiDao;
import com.example.micrometer.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String USER_NOT_FOUND = "User not found with id: {}!";

    private final UsrApiDao usrApiDao;

    @Override
    public SpUserDto getUserInfo(SignPlatformUser principal) {
        SpUserDto userDto = usrApiDao.findUserById(principal.getUserId());
        if (Objects.isNull(userDto)) {
            log.error(USER_NOT_FOUND, principal.getUserId());
        }
        return userDto;
    }

    @Override
    public List<UserCertificateDto> getUserCertificates(SignPlatformUser principal) {
        SpUserDto userById = usrApiDao.findUserById(principal.getUserId());

        if (Objects.isNull(userById)) {
            log.error(USER_NOT_FOUND, principal.getUserId());
        }
        return usrApiDao.getAllUserCertificates(principal.getClientId());
    }
}
