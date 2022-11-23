package com.example.seproject2022.model.dto;

import com.example.seproject2022.model.entity.Account;
import com.example.seproject2022.model.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListAccountDto {

    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
    @JsonProperty("address")
    private ListAddressDto listAddressDto;

    public ListAccountDto(Account account) {
        id = account.getId();
        email = account.getEmail();
        firstName = account.getFirstName();
        lastName = account.getLastName();
        phone = account.getPhone();
        role = account.getRole();
        listAddressDto = new ListAddressDto(account.getAddress());
    }
}
