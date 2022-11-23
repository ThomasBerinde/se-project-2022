package com.example.seproject2022.service;

import com.example.seproject2022.model.dto.CreateOrderRequestDto;
import com.example.seproject2022.model.dto.CreateOrderResponseDto;

public interface OrderService {

    CreateOrderResponseDto createOrder(CreateOrderRequestDto requestDto);
}
