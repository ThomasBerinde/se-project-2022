package com.example.seproject2022.service.impl;

import com.example.seproject2022.model.dto.CategoryDto;
import com.example.seproject2022.model.dto.ProductDtoForPaginationAndGroupByCategory;
import com.example.seproject2022.model.entity.Category;
import com.example.seproject2022.model.entity.Product;
import com.example.seproject2022.repository.CategoryRepository;
import com.example.seproject2022.repository.ProductRepository;
import com.example.seproject2022.service.CategoryService;
import com.example.seproject2022.service.converter.Converter;
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

    @Autowired
    private Converter<Product, ProductDtoForPaginationAndGroupByCategory> productForPaginationAndGroupByCategoryConverter;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CategoryDto> findAll() {
        List<CategoryDto> newListCategoryDto = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAll();
        for(Category category : categoryList) {
            newListCategoryDto.add(categoryConverter.toDto(category));
        }
        return newListCategoryDto;
    }

    @Override
    public List<ProductDtoForPaginationAndGroupByCategory> findProductsByCategory(Long id) {
        List<ProductDtoForPaginationAndGroupByCategory> result = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for(Product product: products) {
            List<Category> categories = product.getCategories();
            for(Category category : categories) {
                if(id.equals(category.getId())) {
                    result.add(productForPaginationAndGroupByCategoryConverter.toDto(product));
                    break;
                }
            }
        }
        return result;
    }
}
