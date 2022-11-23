package com.example.seproject2022.service.impl;

import com.example.seproject2022.model.dto.CreateOrderRequestDto;
import com.example.seproject2022.model.dto.CreateOrderResponseDto;
import com.example.seproject2022.service.OrderService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final

    @Override
    public CreateOrderResponseDto createOrder(CreateOrderRequestDto requestDto) {
        for (Long productId : requestDto.getProductIds()) {

        }
    }
}
