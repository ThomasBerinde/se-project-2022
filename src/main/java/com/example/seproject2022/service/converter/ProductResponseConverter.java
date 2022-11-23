package com.example.seproject2022.service.converter;
import com.example.seproject2022.model.dto.ProductDtoCreateInput;
import com.example.seproject2022.model.dto.ProductDtoCreateResponse;
import com.example.seproject2022.model.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseConverter implements Converter<Product, ProductDtoCreateResponse>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Product toEntity(ProductDtoCreateResponse productDtoCreateResponse) {
        return modelMapper.map(productDtoCreateResponse, Product.class);
    }

    @Override
    public ProductDtoCreateResponse toDto(Product product) {
        return modelMapper.map(product, ProductDtoCreateResponse.class);
    }
}
