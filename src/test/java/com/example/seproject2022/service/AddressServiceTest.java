package com.example.seproject2022.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.seproject2022.exception.CustomException;
import com.example.seproject2022.model.dto.UpdateAddressRequestDto;
import com.example.seproject2022.model.dto.UpdateAddressResponseDto;
import com.example.seproject2022.model.entity.Address;
import com.example.seproject2022.repository.AddressRepository;
import com.example.seproject2022.service.impl.AddressServiceImpl;
import com.example.seproject2022.util.UpdateAddressDtoBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    @Test
    public void shouldUpdateAddress() {
        //given
        UpdateAddressDtoBuilder updateAddressDtoBuilder = new UpdateAddressDtoBuilder();
        updateAddressDtoBuilder.createUpdateAddress();
        UpdateAddressRequestDto updateAddressRequestDto = updateAddressDtoBuilder.build();
        long id = 12l;
        Address expectedAddress = updateAddressRequestDto.toEntity(id);

        //when
        when(addressRepository.findById(id)).thenReturn(Optional.of(expectedAddress));
        when(addressRepository.save(any(Address.class))).thenReturn(expectedAddress);
        UpdateAddressResponseDto result = addressService.updateAddress(updateAddressRequestDto, id, "");

        //then
        assertThat(new UpdateAddressResponseDto(expectedAddress)).usingRecursiveComparison().isEqualTo(result);
    }

    @Test
    public void updateAddressShouldThrowException() {
        //given
        UpdateAddressDtoBuilder updateAddressDtoBuilder = new UpdateAddressDtoBuilder();
        updateAddressDtoBuilder.createUpdateAddress();
        Long id = 12L;
        UpdateAddressRequestDto updateAddressRequestDto = updateAddressDtoBuilder.build();
        Address expectedAddress = updateAddressRequestDto.toEntity(id);

        //when
        when(addressRepository.findById(id)).thenReturn(Optional.empty());
        CustomException customException = assertThrows(CustomException.class, () -> addressService.updateAddress(updateAddressRequestDto, id, ""));

        //then
        assertEquals(String.format("Address with id=`%d` not found", id), customException.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, customException.getHttpStatus());
    }
}
