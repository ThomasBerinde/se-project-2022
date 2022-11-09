package com.example.seproject2022.service.impl;

import com.example.seproject2022.exception.CustomException;
import com.example.seproject2022.model.dto.CreateAccountRequestDto;
import com.example.seproject2022.model.dto.CreateAccountResponseDto;
import com.example.seproject2022.model.dto.CreateAddressRequestDto;
import com.example.seproject2022.model.dto.ListAccountDto;
import com.example.seproject2022.model.entity.Account;
import com.example.seproject2022.model.entity.Address;
import com.example.seproject2022.repository.AccountRepository;
import com.example.seproject2022.repository.AddressRepository;
import com.example.seproject2022.service.AccountService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AddressRepository addressRepository;

    @Override
    public List<ListAccountDto> listAllAccounts() {
        return accountRepository.findAll()
                                .stream()
                                .map(ListAccountDto::new)
                                .toList();
    }

    @Override
    public CreateAccountResponseDto createAccount(CreateAccountRequestDto accountDto,
                                                  String uri) {
        CreateAddressRequestDto addressDto = accountDto.getAddressDto();
        Account account = accountRepository.findByEmail(accountDto.getEmail());
        if (account != null) {
            throw new CustomException(String.format("There is already an account associated with the email '%s'", accountDto.getEmail()),
                                      HttpStatus.BAD_REQUEST, uri);
        }
        Address address = addressRepository.findAllByStreetAndNumberAndCityAndCountyAndCountryAndPostCode(addressDto.getStreet(),
                                                                                                          addressDto.getNumber(),
                                                                                                          addressDto.getCity(),
                                                                                                          addressDto.getCounty(),
                                                                                                          addressDto.getCountry(),
                                                                                                          addressDto.getPostCode());
        if (address == null) {
            address = addressRepository.save(addressDto.toEntity());
        }
        Account newAccount = accountRepository.save(accountDto.toEntity(address));
        return new CreateAccountResponseDto(newAccount);
    }
}
