package com.example.seproject2022.model.dto;

import com.example.seproject2022.model.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateAddressRequestDto {

    private String street;
    private String number;
    private String city;
    private String county;
    private String country;
    private String postCode;

    public Address toEntity(long id) {
        Address address = new Address();
        address.setId(id);
        address.setStreet(street);
        address.setNumber(number);
        address.setCity(city);
        address.setCounty(county);
        address.setCountry(country);
        address.setPostCode(postCode);
        return address;
    }
}
