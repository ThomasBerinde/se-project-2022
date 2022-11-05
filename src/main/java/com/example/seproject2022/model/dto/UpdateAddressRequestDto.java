package com.example.seproject2022.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressRequestDto {

    private String street;
    private String number;
    private String city;
    private String county;
    private String country;
    private String postCode;
}
