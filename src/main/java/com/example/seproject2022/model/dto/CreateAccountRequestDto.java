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

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequestDto {
    private static final String REGEX_ROMANIAN_PHONE = "^([+][4][0]|[0][0]|[0])[1-9][0-9]{8}$";
    private static final String REGEX_FOR_NAME = "^[a-zA-Z]((?! {2})[a-zA-z ]){2,}$";
    private static final String INVALID_NAME = "Name can not be null and can contain only letters and spaces";
    private static final String INVALID_PHONE_NUMBER =
        "The phone number can have the prefixes: +40 or 00 or just 0. Just romanian numbers only";
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = REGEX_FOR_NAME, message = INVALID_NAME)
    private String firstName;

    @Pattern(regexp = REGEX_FOR_NAME, message = INVALID_NAME)
    private String lastName;

    @Pattern(regexp = REGEX_ROMANIAN_PHONE, message = INVALID_PHONE_NUMBER)
    private String phone;

    @NotNull(message = "Password cannot be null or empty")
    private String password;

    @NotNull(message = "Address cannot be null or empty")
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
