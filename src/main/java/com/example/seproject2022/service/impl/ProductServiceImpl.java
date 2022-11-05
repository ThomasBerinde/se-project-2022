package com.example.seproject2022.service.impl;

import com.example.seproject2022.exception.CustomException;
import com.example.seproject2022.model.dto.*;
import com.example.seproject2022.model.entity.Category;
import com.example.seproject2022.model.entity.Product;
import com.example.seproject2022.repository.CategoryRepository;
import com.example.seproject2022.repository.ProductRepository;
import com.example.seproject2022.service.ProductService;
import com.example.seproject2022.service.converter.Converter;
import com.example.seproject2022.service.converter.PageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static final String DO_NOT_EXIST_MESSAGE = "Not found";
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Converter<Product, ProductDtoUpdateDelete> productDtoUpdateDeleteConverter;

    @Autowired
    private Converter<Product, ProductDtoCreateInput> productDtoCreateInputConverter;

    @Autowired
    private Converter<Product, ProductDtoCreateResponse> productDtoCreateResponseConverter;

    @Autowired
    private Converter<Product, ProductDtoForPagination> productDtoForPaginationConverter;
    private PageConverter<Product> pageToPageDTOMapper;

    @Override
    public ProductDtoUpdateDelete updateProductById(Long id, ProductDtoUpdateDelete productDto) throws CustomException{
        ProductDtoUpdateDelete oldProductDto = this.findProduct(id);
        this.updateOldProduct(oldProductDto, productDto);
        return productDtoUpdateDeleteConverter.toDto(productRepository.save(productDtoUpdateDeleteConverter.toEntity(oldProductDto)));
    }

    @Override
    @Transactional
    public ProductDtoCreateResponse saveProduct(ProductDtoCreateInput productDtoCreateInput) {
        if (this.findProductByName(productDtoCreateInput.getName())) {
            throw new CustomException("Name already exists", HttpStatus.BAD_REQUEST, "/products");
        }
        List<Long> categoryIds = productDtoCreateInput.getCategoryIds();
        List<Category> categories = new ArrayList<>();
        for(Long id : categoryIds) {
            Category category = categoryRepository.findById(id).orElseThrow(() -> new CustomException("Category doesn't exist", HttpStatus.NOT_FOUND, "/categories/" + id));
            categories.add(category);
        }
        Product product = productDtoCreateInputConverter.toEntity(productDtoCreateInput);
        product.setCategories(categories);
        return productDtoCreateResponseConverter.toDto(productRepository.save(product));
    }

    @Override
    public PageDto<ProductDtoForPagination> getProducts(Pageable productPage) {
        Page<Product> page =  productRepository.findAll(productPage);
        PageDto<ProductDtoForPagination> newPage = (PageDto<ProductDtoForPagination>) page.map(resource -> productDtoForPaginationConverter.toDto(resource));
        return newPage;
    }

    @Override
    public void deleteProductById(Long id) throws CustomException{
        this.findProduct(id);
        productRepository.deleteById(id);
    }

    private void updateOldProduct(ProductDtoUpdateDelete oldProductDto, ProductDtoUpdateDelete newProductDto) {
        oldProductDto.setAmount(newProductDto.getAmount());
        oldProductDto.setPrice(newProductDto.getPrice());
        oldProductDto.setName(newProductDto.getName());
        oldProductDto.setDescription(newProductDto.getDescription());
        oldProductDto.setImgUrl(newProductDto.getImgUrl());
    }

    private ProductDtoUpdateDelete findProduct(Long id) {
        return productDtoUpdateDeleteConverter.toDto(productRepository.findProductById(id).orElseThrow(
                () -> new CustomException(DO_NOT_EXIST_MESSAGE, HttpStatus.NOT_FOUND, "products/" + id)));
    }

    private boolean findProductByName(String name) {
        return productRepository.findByName(name).isPresent();
    }
}
