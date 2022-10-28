package com.example.seproject2022.service.converter;

import org.springframework.stereotype.Component;

@Component
public interface Converter<T, E> {

    T toEntity(E object);

    E toDto(T object);
}
