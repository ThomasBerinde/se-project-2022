package com.example.seproject2022.service.impl;

import com.example.seproject2022.model.dto.CategoryDto;
import com.example.seproject2022.model.entity.Category;
import com.example.seproject2022.repository.CategoryRepository;
import com.example.seproject2022.service.CategoryService;
import com.example.seproject2022.service.converter.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Converter<Category, CategoryDto> categoryConverter;

    @Override
    public List<CategoryDto> findAll() {
        List<CategoryDto> newListCategoryDto = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAll();
        for(Category category : categoryList) {
            newListCategoryDto.add(categoryConverter.toDto(category));
        }
        return newListCategoryDto;
    }
}
