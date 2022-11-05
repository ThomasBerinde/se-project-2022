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
public class UpdateAddressResponseDto {

    private long id;
    private String street;
    private String number;
    private String city;
    private String county;
    private String country;
    private String postCode;

    public UpdateAddressResponseDto(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.city = address.getCity();
        this.county = address.getCounty();
        this.country = address.getCountry();
        this.postCode = address.getPostCode();
    }
}