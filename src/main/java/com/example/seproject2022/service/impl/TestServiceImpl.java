package com.example.seproject2022.service.impl;

import com.example.seproject2022.repository.AccountRepository;
import com.example.seproject2022.service.TestService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

        private final AccountRepository accountRepository;

        @Override
        public String deleteAcceptanceAccounts() {
                try {
                        accountRepository.deleteAccountsByEmailStartsWith("acceptance");
                } catch (Exception e) {
                        return "An unexpected error occurred";
                }
                return "Successfully deleted accounts created by acceptance tests";
        }
}
