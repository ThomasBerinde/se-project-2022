package com.example.seproject2022.controller;

import com.example.seproject2022.service.TestService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

        private final TestService testService;

        @DeleteMapping("/accounts")
        public ResponseEntity<String> deleteAcceptanceAccounts(HttpServletRequest request) {
                return new ResponseEntity<>(testService.deleteAcceptanceAccounts(), HttpStatus.OK);
        }
}
