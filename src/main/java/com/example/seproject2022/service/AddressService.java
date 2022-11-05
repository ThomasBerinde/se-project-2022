package com.example.seproject2022.service;

import com.example.seproject2022.exceptions.NotFoundException;
import com.example.seproject2022.model.dto.UpdateAddressResponseDto;
import com.example.seproject2022.model.dto.UpdateAddressRequestDto;

public interface AddressService {

    UpdateAddressResponseDto updateAddress(long addressId, UpdateAddressRequestDto updateAddressRequestDto);
}
