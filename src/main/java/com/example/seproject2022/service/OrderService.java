package com.example.seproject2022.service;

import com.example.seproject2022.model.dto.CreateOrderRequestDto;

public interface OrderService {

    String createOrder(CreateOrderRequestDto createOrderRequestDto,
                       String uri);
}
