package com.example.seproject2022.model.dto;

import com.example.seproject2022.model.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressRequestDto {
    private static final String REGEX_POST_CODE = "^[0-9]{1,}$";
    private static final String INVALID_POST_CODE = "The postal code must contain just digits";

    @NotNull(message = "Street cannot be null or empty")
    private String street;

    @NotNull(message = "Number cannot be null or empty")
    private String number;

    @NotNull(message = "City cannot be null or empty")
    private String city;

    @NotNull(message = "County cannot be null or empty")
    private String county;

    @NotNull(message = "Country cannot be null or empty")
    private String country;

    @Pattern(regexp = REGEX_POST_CODE, message = INVALID_POST_CODE)
    private String postCode;

    public Address toEntity() {
        Address address = new Address();
        address.setId(0L);
        address.setStreet(street);
        address.setNumber(number);
        address.setCity(city);
        address.setCounty(county);
        address.setCountry(country);
        address.setPostCode(postCode);
        return address;
    }
}
