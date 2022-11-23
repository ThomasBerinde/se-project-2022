package com.example.seproject2022.service.converter;

import com.example.seproject2022.model.dto.ProductDtoCreateInput;
import com.example.seproject2022.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductCreateInputConverter implements Converter<Product, ProductDtoCreateInput> {

    private final ModelMapper modelMapper;

    @Override
    public Product toEntity(ProductDtoCreateInput productDtoCreateInput) {
        return modelMapper.map(productDtoCreateInput, Product.class);
    }

    @Override
    public ProductDtoCreateInput toDto(Product product) {
        return modelMapper.map(product, ProductDtoCreateInput.class);
    }
}
