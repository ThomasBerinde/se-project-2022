package com.example.seproject2022.model.dto;

import com.example.seproject2022.model.entity.Account;
import com.example.seproject2022.model.entity.Address;
import com.example.seproject2022.model.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequestDto {

    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    @JsonProperty("address")
    private CreateAddressRequestDto addressDto;

    public Account toEntity(Address address) {
        Account account = new Account();
        account.setId(0L);
        account.setEmail(email);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setPhone(phone);
        account.setPassword(BCrypt.withDefaults()
                                  .hashToString(10, password.toCharArray()));
        account.setRole(Role.USER);
        account.setAddress(address);
        return account;
    }
}
