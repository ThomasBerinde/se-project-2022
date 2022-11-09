package com.example.seproject2022.service.impl;

import com.example.seproject2022.exception.CustomException;
import com.example.seproject2022.model.dto.UpdateAddressRequestDto;
import com.example.seproject2022.model.dto.UpdateAddressResponseDto;
import com.example.seproject2022.model.entity.Address;
import com.example.seproject2022.repository.AddressRepository;
import com.example.seproject2022.service.AddressService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public UpdateAddressResponseDto updateAddress(UpdateAddressRequestDto addressDto,
                                                  long addressId,
                                                  String uri) {
        Address address = addressRepository.findById(addressId)
                                           .orElse(null);
        if (address == null) {
            throw new CustomException(String.format("Address with id=`%d` not found", addressId), HttpStatus.NOT_FOUND, uri);
        }
        Address newAddress = addressDto.toEntity(address.getId());
        return new UpdateAddressResponseDto(addressRepository.save(newAddress));
    }
}
