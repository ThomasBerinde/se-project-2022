package com.example.seproject2022.service.converter;

import com.example.seproject2022.model.dto.MessageDto;
import com.example.seproject2022.model.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<Category, MessageDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Category toEntity(MessageDto messageDto) {
        return modelMapper.map(messageDto, Category.class);
    }

    @Override
    public MessageDto toDto(Category message) {
        return modelMapper.map(message, MessageDto.class);
    }
}
