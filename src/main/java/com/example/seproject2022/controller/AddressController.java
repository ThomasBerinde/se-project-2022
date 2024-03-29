package com.example.seproject2022.controller;

import com.example.seproject2022.model.dto.UpdateAddressRequestDto;
import com.example.seproject2022.model.dto.UpdateAddressResponseDto;
import com.example.seproject2022.service.AddressService;
import com.example.seproject2022.service.ValidatorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final ValidatorService validatorService;
    private final AddressService addressService;

    @PutMapping("/{id}")
    public ResponseEntity<UpdateAddressResponseDto> updateAddress(@RequestBody @Validated UpdateAddressRequestDto updateAddressRequestDto,
                                                                  @RequestHeader(value = "jwt", required = false) String jwt,
                                                                  @PathVariable long id,
                                                                  HttpServletRequest request) {
        String uri = request.getRequestURI();
        validatorService.validateIsUser(jwt, uri);
        return new ResponseEntity<>(addressService.updateAddress(updateAddressRequestDto, id, uri), HttpStatus.OK);
    }
}
