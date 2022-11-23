package com.example.seproject2022.service.converter;

import com.example.seproject2022.model.dto.ProductDtoUpdate;
import com.example.seproject2022.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductUpdateConverter implements Converter<Product, ProductDtoUpdate> {

    private final ModelMapper modelMapper;

    @Override
    public Product toEntity(ProductDtoUpdate productDtoUpdateDelete) {
        return modelMapper.map(productDtoUpdateDelete, Product.class);
    }

    @Override
    public ProductDtoUpdate toDto(Product product) {
        return modelMapper.map(product, ProductDtoUpdate.class);
    }
}
