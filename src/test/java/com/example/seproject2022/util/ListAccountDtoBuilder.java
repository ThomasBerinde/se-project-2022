package com.example.seproject2022.util;

import static com.example.seproject2022.model.entity.Role.ADMIN;

import com.example.seproject2022.model.dto.ListAccountDto;
import com.example.seproject2022.model.dto.ListAddressDto;

import java.util.ArrayList;
import java.util.List;

public class ListAccountDtoBuilder {
    private final List<ListAccountDto> accountDtos;

    public ListAccountDtoBuilder() {
        this.accountDtos = new ArrayList<>();
    }

    public List<ListAccountDto> build() {
        return accountDtos;
    }

    public static ListAccountDtoBuilder defaultValues() {
        return new ListAccountDtoBuilder();
    }

    public static ListAccountDtoBuilder create() {
        ListAccountDtoBuilder listAccountDtoBuilder = defaultValues();
        listAccountDtoBuilder.setAccountDtos();
        return listAccountDtoBuilder;
    }

    public ListAccountDtoBuilder setAccountDtos() {
        ListAccountDto listAccountDto = new ListAccountDto();
        listAccountDto.setListAddressDto(createNewAddress());
        listAccountDto.setEmail("mihai@gmail.com");
        listAccountDto.setPhone("0755798666");
        listAccountDto.setId(1);
        listAccountDto.setLastName("Mihai");
        listAccountDto.setFirstName("Emil");
        listAccountDto.setRole(ADMIN);
        this.accountDtos.add(listAccountDto);
        return this;
    }

    private ListAddressDto createNewAddress() {
        ListAddressDto listAddressDto = new ListAddressDto();
        listAddressDto.setCity("Cluj-Napoca");
        listAddressDto.setId(1);
        listAddressDto.setCountry("Romania");
        listAddressDto.setNumber("A1C");
        listAddressDto.setCounty("Cluj");
        listAddressDto.setStreet("Libertatii");
        listAddressDto.setPostCode("111");
        return listAddressDto;
    }
}
