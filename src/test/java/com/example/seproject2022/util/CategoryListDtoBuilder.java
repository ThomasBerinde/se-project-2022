package com.example.seproject2022.util;

import com.example.seproject2022.model.dto.CategoryDto;
import com.example.seproject2022.model.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryListDtoBuilder {

    private final List<CategoryDto> categories;


    public CategoryListDtoBuilder() {
        this.categories = new ArrayList<>();
    }

    public List<CategoryDto> build() {
        return categories;
    }

    public static CategoryListDtoBuilder defaultValues() {
        return new CategoryListDtoBuilder();
    }

    public static CategoryListDtoBuilder categoriesDto(List<Category> categories) {
        CategoryListDtoBuilder categoryListDtoBuilder = defaultValues();
        categoryListDtoBuilder.setListCategories(categories);
        return categoryListDtoBuilder;
    }

    public CategoryListDtoBuilder setListCategories(List<Category> categories) {
        CategoryDto newCategoryDto = new CategoryDto();
        for(Category category : categories) {
            newCategoryDto.setId(category.getId());
            newCategoryDto.setName(category.getName());
            this.categories.add(newCategoryDto);
        }
        return this;
    }
}
