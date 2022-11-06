package com.example.seproject2022.service;

import com.example.seproject2022.model.dto.CategoryDto;
import com.example.seproject2022.model.dto.ProductDtoForPaginationAndGroupByCategory;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    List<ProductDtoForPaginationAndGroupByCategory> findProductsByCategory(Long id);
}
