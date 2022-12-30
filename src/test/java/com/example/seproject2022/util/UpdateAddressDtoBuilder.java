package com.example.seproject2022.util;

import com.example.seproject2022.model.dto.UpdateAddressRequestDto;
import net.bytebuddy.utility.RandomString;

import java.util.Random;

public class UpdateAddressDtoBuilder {
    private UpdateAddressRequestDto updateAddressRequestDto;

    public void createUpdateAddress() {
        Random random = new Random();
        RandomString randomString = new RandomString(10);
        UpdateAddressRequestDto updateAddressRequestDto = new UpdateAddressRequestDto();
        updateAddressRequestDto.setCity(randomString.nextString());
        updateAddressRequestDto.setCounty(randomString.nextString());
        updateAddressRequestDto.setStreet(randomString.nextString());
        updateAddressRequestDto.setNumber("A1C");
        updateAddressRequestDto.setPostCode("2141");
        updateAddressRequestDto.setCountry(randomString.nextString());
        this.updateAddressRequestDto = updateAddressRequestDto;
    }

    public UpdateAddressRequestDto build() {
        return updateAddressRequestDto;
    }
}
