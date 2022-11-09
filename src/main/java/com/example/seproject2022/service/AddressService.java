package com.example.seproject2022.service;

import com.example.seproject2022.model.dto.UpdateAddressRequestDto;
import com.example.seproject2022.model.dto.UpdateAddressResponseDto;

public interface AddressService {

    UpdateAddressResponseDto updateAddress(UpdateAddressRequestDto updateAddressRequestDto,
                                           long addressId,
                                           String uri);
}
