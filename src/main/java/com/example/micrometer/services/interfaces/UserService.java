package com.example.micrometer.services.interfaces;


import com.example.micrometer.dto.SignPlatformUser;
import com.example.micrometer.dto.SpUserDto;
import com.example.micrometer.dto.UserCertificateDto;

import java.util.List;

public interface UserService {
    SpUserDto getUserInfo(SignPlatformUser principal);

    List<UserCertificateDto> getUserCertificates(SignPlatformUser principal);
}
