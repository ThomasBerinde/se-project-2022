package com.example.seproject2022.service.converter;

import com.example.seproject2022.model.dto.ProductDtoForPaginationAndGroupByCategory;
import com.example.seproject2022.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductForPaginationAndGroupByCategoryConverter implements Converter<Product, ProductDtoForPaginationAndGroupByCategory> {

    private final ModelMapper modelMapper;

    @Override
    public Product toEntity(ProductDtoForPaginationAndGroupByCategory productDtoForPagination) {
        return modelMapper.map(productDtoForPagination, Product.class);
    }

    @Override
    public ProductDtoForPaginationAndGroupByCategory toDto(Product product) {
        return modelMapper.map(product, ProductDtoForPaginationAndGroupByCategory.class);
    }
}
