package com.example.seproject2022.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.seproject2022.model.dto.UpdateAddressRequestDto;
import com.example.seproject2022.model.dto.UpdateAddressResponseDto;
import com.example.seproject2022.model.entity.Address;
import com.example.seproject2022.service.AddressService;
import com.example.seproject2022.service.ValidatorService;
import com.example.seproject2022.util.UpdateAddressDtoBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
public class AddressControllerTest {

    @Mock
    private AddressService addressService;

    @Mock
    private ValidatorService validatorService;

    @InjectMocks
    private AddressController addressController;

    @Test
    public void shouldUpdateAddress() {
        //given
        UpdateAddressDtoBuilder updateAddressDtoBuilder = new UpdateAddressDtoBuilder();
        updateAddressDtoBuilder.createUpdateAddress();
        Long id = 12L;
        UpdateAddressRequestDto updateAddressRequestDto = updateAddressDtoBuilder.build();
        Address expectedAddress = updateAddressRequestDto.toEntity(id);
        UpdateAddressResponseDto expectedResult = new UpdateAddressResponseDto(expectedAddress);
        HttpServletRequest request = mock(HttpServletRequest.class);

        //when
        when(addressService.updateAddress(updateAddressRequestDto, id, request.getRequestURI())).thenReturn(expectedResult);
        ResponseEntity<UpdateAddressResponseDto> result = addressController.updateAddress(updateAddressRequestDto, "VVNFUg==", id, request);

        //then
        assertEquals(expectedResult, result.getBody());
    }
}
