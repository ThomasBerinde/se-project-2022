package com.example.seproject2022.service.impl;

import com.example.seproject2022.exception.CustomException;
import com.example.seproject2022.model.dto.LoginRequestDto;
import com.example.seproject2022.model.dto.LoginResponseDto;
import com.example.seproject2022.model.entity.Account;
import com.example.seproject2022.service.AccountService;
import com.example.seproject2022.service.LoginService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Base64;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AccountService accountService;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto,
                                  String uri) {
        Account account = accountService.findByEmail(loginRequestDto.getEmail());
        if (account == null) {
            throw new CustomException("Invalid email", HttpStatus.BAD_REQUEST, uri);
        }
        if (!BCrypt.verifyer()
                   .verify(loginRequestDto.getPassword()
                                          .toCharArray(), account.getPassword()
                                                                 .toCharArray()).verified) {
            throw new CustomException("Invalid password", HttpStatus.BAD_REQUEST, uri);
        }
        return new LoginResponseDto(new String(Base64.getEncoder()
                                                     .encode(account.getRole()
                                                                    .toString()
                                                                    .getBytes())));
    }
}
