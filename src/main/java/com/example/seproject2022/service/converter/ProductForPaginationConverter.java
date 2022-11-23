package com.example.seproject2022.service.converter;

import com.example.seproject2022.model.dto.ProductDtoForPagination;
import com.example.seproject2022.model.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductForPaginationConverter implements Converter<Product, ProductDtoForPagination>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Product toEntity(ProductDtoForPagination productDtoForPagination) {
        return modelMapper.map(productDtoForPagination, Product.class);
    }

    @Override
    public ProductDtoForPagination toDto(Product product) {
        return modelMapper.map(product, ProductDtoForPagination.class);
    }
}
