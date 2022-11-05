package com.example.seproject2022.service.converter;

import com.example.seproject2022.model.dto.ProductDtoForPagination;
import com.example.seproject2022.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductForPaginationConverter implements Converter<Product, ProductDtoForPagination> {

    private final ModelMapper modelMapper;

    @Override
    public Product toEntity(ProductDtoForPagination productDtoForPagination) {
        return modelMapper.map(productDtoForPagination, Product.class);
    }

    @Override
    public ProductDtoForPagination toDto(Product product) {
        return modelMapper.map(product, ProductDtoForPagination.class);
    }
}
