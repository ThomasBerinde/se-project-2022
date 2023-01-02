package com.example.seproject2022.controller;

import com.example.seproject2022.model.dto.CreateOrderRequestDto;
import com.example.seproject2022.model.dto.CreateOrderResponseDto;
import com.example.seproject2022.service.OrderService;
import com.example.seproject2022.service.ValidatorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

        private final OrderService orderService;
        private final ValidatorService validatorService;

        @PostMapping()
        public ResponseEntity<CreateOrderResponseDto> create(@RequestHeader(value = "jwt", required = false) String jwt,
                                                             @RequestBody @Validated CreateOrderRequestDto createOrderRequestDto,
                                                             HttpServletRequest request) {
                validatorService.validateIsUser(jwt, request.getRequestURI());
                return new ResponseEntity<>(orderService.createOrder(createOrderRequestDto, request.getRequestURI()),
                                            HttpStatus.OK);
        }
}
