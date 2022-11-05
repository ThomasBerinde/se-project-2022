package com.example.seproject2022.service.converter;

import com.example.seproject2022.model.dto.CategoryDto;
import com.example.seproject2022.model.entity.Category;
import com.example.seproject2022.service.converter.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<Category, CategoryDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Category toEntity(CategoryDto messageDto) {
        return modelMapper.map(messageDto, Category.class);
    }

    @Override
    public CategoryDto toDto(Category message) {
        return modelMapper.map(message, CategoryDto.class);
    }
}
