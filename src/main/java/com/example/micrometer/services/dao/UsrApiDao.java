package com.example.micrometer.services.dao;

import com.example.micrometer.dto.CertificateDto;
import com.example.micrometer.dto.SpUserDto;
import com.example.micrometer.dto.UserCertificateDto;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Repository
public class UsrApiDao {

    private final HashMap<Long, SpUserDto> map = new HashMap<>();

    @PostConstruct
    public void init() {
        SpUserDto spUserDto1 = new SpUserDto()
            .setUserId(1L)
            .setClientId(1L)
            .setInn("Inn1");

        SpUserDto spUserDto2 = new SpUserDto()
            .setUserId(2L)
            .setClientId(2L)
            .setInn("Inn2");
        map.put(1L, spUserDto1);
        map.put(2L, spUserDto2);
    }

    public SpUserDto findUserById(Long userId) {
        return map.get(userId);
    }

    public List<UserCertificateDto> getAllUserCertificates(Long clientId) {

        SpUserDto spUserDto = map.get(clientId);
        UserCertificateDto userCertificateDto = new UserCertificateDto();
        CertificateDto certificateDto = new CertificateDto().setNum(spUserDto.getInn());

        userCertificateDto.setClientId(spUserDto.getClientId());
        userCertificateDto.setCertificateId(spUserDto.getClientId());
        userCertificateDto.setCertificateDto(certificateDto);

        return List.of(userCertificateDto);
    }
}
