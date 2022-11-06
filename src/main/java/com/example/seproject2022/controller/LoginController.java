package com.example.seproject2022.controller;

import com.example.seproject2022.model.dto.LoginRequestDto;
import com.example.seproject2022.model.dto.LoginResponseDto;
import com.example.seproject2022.service.LoginService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping()
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto,
                                                  HttpServletRequest request) {
        return new ResponseEntity<>(loginService.login(loginRequestDto, request.getRequestURI()), HttpStatus.OK);
    }
}
