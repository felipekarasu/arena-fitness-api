package com.karasusoft.arenafitnessapi.dto;

import com.karasusoft.arenafitnessapi.enums.UserStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDto {

    String document;
    String firstName;
    String lastName;
    String gender;
    String phoneNumber;
    String email;
    LocalDateTime DoB;
    LocalDateTime creationDate;
    UserStatus userStatus;

    @Getter(AccessLevel.NONE)
    List<AddressDto> addressDtoList;

    public List<AddressDto> getAddressDtoList() {

        if( addressDtoList == null) {
            addressDtoList = new ArrayList<>();
        }

        return addressDtoList;
    }
}
