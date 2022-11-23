package com.example.seproject2022.service.converter;

import com.example.seproject2022.model.dto.ProductDtoCreateInput;
import com.example.seproject2022.model.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductInputConverter implements Converter<Product, ProductDtoCreateInput>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Product toEntity(ProductDtoCreateInput productDtoCreateInput) {
        return modelMapper.map(productDtoCreateInput, Product.class);
    }

    @Override
    public ProductDtoCreateInput toDto(Product product) {
        return modelMapper.map(product, ProductDtoCreateInput.class);
    }
}
