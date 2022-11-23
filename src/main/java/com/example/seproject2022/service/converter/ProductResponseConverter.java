package com.example.seproject2022.service.converter;

import com.example.seproject2022.model.dto.ProductDtoCreateProductResponse;
import com.example.seproject2022.model.entity.Category;
import com.example.seproject2022.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductResponseConverter {

    public ProductDtoCreateProductResponse toDto(Product product) {
        ProductDtoCreateProductResponse productDtoCreateResponse = new ProductDtoCreateProductResponse();
        List<Long> categoryIds = new ArrayList<>();
        List<Category> categories = product.getCategories();
        for(Category category: categories) {
            categoryIds.add(category.getId());
        }
        productDtoCreateResponse.setId(product.getId());
        productDtoCreateResponse.setName(product.getName());
        productDtoCreateResponse.setAmount(product.getAmount());
        productDtoCreateResponse.setPrice(product.getPrice());
        productDtoCreateResponse.setCategoryIds(categoryIds);
        productDtoCreateResponse.setImgUrl(product.getImgUrl());
        productDtoCreateResponse.setDescription(product.getDescription());
        return productDtoCreateResponse;
    }
}
