package com.example.micrometer.mapper;

import com.example.micrometer.api.models.response.UserCertificateJson;
import com.example.micrometer.dto.UserCertificateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserCertificateMapper {
    UserCertificateMapper MAPPER = Mappers.getMapper(UserCertificateMapper.class);

    @Mapping(source = "certificateDto", target = ".")
    @Mapping(source = "certificateDto.num", target = "certificateNumber")
    @Mapping(source = "certificateId", target = "id")
    UserCertificateJson map(UserCertificateDto dto);
}
