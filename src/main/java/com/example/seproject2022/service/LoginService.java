package com.example.seproject2022.service;

import com.example.seproject2022.model.dto.LoginRequestDto;
import com.example.seproject2022.model.dto.LoginResponseDto;

public interface LoginService {

    LoginResponseDto login(LoginRequestDto loginRequestDto,
                           String uri);
}
