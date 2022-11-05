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
public class ListAddressDto {

    private long id;
    private String street;
    private String number;
    private String city;
    private String county;
    private String country;
    private String postCode;

    public ListAddressDto(Address address) {
        id = address.getId();
        street = address.getStreet();
        number = address.getNumber();
        city = address.getCity();
        county = address.getCounty();
        country = address.getCountry();
        postCode = address.getPostCode();
    }
}
