package com.example.seproject2022.controller;

import com.example.seproject2022.model.dto.CreateAccountRequestDto;
import com.example.seproject2022.model.dto.CreateAccountResponseDto;
import com.example.seproject2022.model.dto.ListAccountDto;
import com.example.seproject2022.service.AccountService;
import com.example.seproject2022.service.ValidatorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final ValidatorService validatorService;

    @GetMapping()
    public ResponseEntity<List<ListAccountDto>> listAllAccounts(@RequestHeader(value = "jwt", required = false) String role,
                                                                HttpServletRequest request) {
        validatorService.validateIsAdmin(role, request.getRequestURI());
        return new ResponseEntity<>(accountService.listAllAccounts(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CreateAccountResponseDto> createAccount(@RequestBody CreateAccountRequestDto accountDto,
                                                                  HttpServletRequest request) {
        return new ResponseEntity<>(accountService.createAccount(accountDto, request.getRequestURI()), HttpStatus.OK);
    }
}
