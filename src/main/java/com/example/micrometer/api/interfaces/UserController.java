package com.example.micrometer.api.interfaces;


import com.example.micrometer.api.models.response.SpUserJson;
import com.example.micrometer.api.models.response.UserCertificateJson;
import com.example.micrometer.dto.SignPlatformUser;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;



public interface UserController {

    @PostMapping(UserRoute.USERS)
    SpUserJson getUserInfo(SignPlatformUser principal);

    @PostMapping(UserRoute.USER_CERTS)
    List<UserCertificateJson> getUserCertificates(SignPlatformUser principal);
}
