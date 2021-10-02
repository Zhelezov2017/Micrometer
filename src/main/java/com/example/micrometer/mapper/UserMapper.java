package com.example.micrometer.mapper;

import com.example.micrometer.api.models.response.SpUserJson;
import com.example.micrometer.dto.SpUserDto;
import com.example.micrometer.dto.UserAddressDto;
import com.example.micrometer.dto.UserPersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    default SpUserJson toSpUserShared(SpUserDto spUserDto) {
        if (spUserDto == null) {
            return null;
        }

        SpUserJson response = new SpUserJson();
        response.setUserId(String.valueOf(spUserDto.getUserId()));
        response.setSnils(spUserDto.getSnils());
        response.setInn(spUserDto.getInn());
        response.setUserId(String.valueOf(spUserDto.getUserId()));

        if (!CollectionUtils.isEmpty(spUserDto.getUserPersonDtoList())) {
            UserPersonDto userPersonDto = spUserDto.getUserPersonDtoList().get(0);
            response.setFirstName(userPersonDto.getFirstName());
            response.setMiddleName(userPersonDto.getMiddleName());
            response.setLastName(userPersonDto.getLastName());
        }

        List<UserAddressDto> userAddressDtoList = spUserDto.getUserAddressDtoList();
        if (!CollectionUtils.isEmpty(userAddressDtoList)) {
            List<SpUserJson.AddressJson> userAddresses = userAddressDtoList.stream()
                .map(this::toAddressJson)
                .collect(Collectors.toList());

            response.setAddresses(userAddresses);
        }


        return response;
    }

    default SpUserJson.AddressJson toAddressJson(UserAddressDto address) {
        return SpUserJson.AddressJson.builder()
            .fullAddress(address.getFullAddress())
            .build();
    }
}
