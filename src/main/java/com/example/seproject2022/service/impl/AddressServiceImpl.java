package com.example.seproject2022.service.impl;

import com.example.seproject2022.exceptions.NotFoundException;
import com.example.seproject2022.model.dto.UpdateAddressRequestDto;
import com.example.seproject2022.model.dto.UpdateAddressResponseDto;
import com.example.seproject2022.model.entity.Address;
import com.example.seproject2022.repository.AddressRepository;
import com.example.seproject2022.service.AddressService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public UpdateAddressResponseDto updateAddress(long addressId,
                                                  UpdateAddressRequestDto updateAddressRequestDto) {
        Address address = addressRepository.findById(addressId).orElse(null);
        if (address == null) {
            throw new NotFoundException(String.format("Address with id=`%d` not found", addressId));
        }
        Address newAddress = new Address(updateAddressRequestDto, addressId);
        return new UpdateAddressResponseDto(addressRepository.save(newAddress));
    }
}
