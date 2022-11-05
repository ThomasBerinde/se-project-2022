package com.example.seproject2022.model.dto;

import com.example.seproject2022.model.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressRequestDto {

    private String street;
    private String number;
    private String city;
    private String county;
    private String country;
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
