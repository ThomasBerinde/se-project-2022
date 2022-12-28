package com.example.seproject2022.service;

import com.example.seproject2022.model.dto.CreateAccountRequestDto;
import com.example.seproject2022.model.dto.CreateAccountResponseDto;
import com.example.seproject2022.model.dto.ListAccountDto;
import com.example.seproject2022.model.entity.Account;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    List<ListAccountDto> listAllAccounts();

    CreateAccountResponseDto createAccount(CreateAccountRequestDto accountDto,
                                           String uri);

    Account findByEmail(String email);
}
