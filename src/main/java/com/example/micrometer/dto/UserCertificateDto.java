package com.example.micrometer.dto;

import lombok.Data;

@Data
public class UserCertificateDto {

    private Long certificateId;
    private Long clientId;

    private CertificateDto certificateDto;
}
