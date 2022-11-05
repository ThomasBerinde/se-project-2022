package com.example.seproject2022.service.impl;

import com.example.seproject2022.exception.CustomException;
import com.example.seproject2022.model.dto.PageDto;
import com.example.seproject2022.model.dto.ProductDtoCreateInput;
import com.example.seproject2022.model.dto.ProductDtoCreateProductResponse;
import com.example.seproject2022.model.dto.ProductDtoForPagination;
import com.example.seproject2022.model.dto.ProductDtoUpdate;
import com.example.seproject2022.model.entity.Category;
import com.example.seproject2022.model.entity.Product;
import com.example.seproject2022.repository.CategoryRepository;
import com.example.seproject2022.repository.ProductRepository;
import com.example.seproject2022.service.ProductService;
import com.example.seproject2022.service.converter.Converter;
import com.example.seproject2022.service.converter.PageToPageDtoConverter;
import com.example.seproject2022.service.converter.ProductResponseConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final String DO_NOT_EXIST_MESSAGE = "Not found";
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final Converter<Product, ProductDtoUpdate> productDtoUpdateDeleteConverter;
    private final ProductResponseConverter productResponseConverter;
    private final Converter<Product, ProductDtoCreateInput> productDtoCreateInputConverter;

    private final Converter<Product, ProductDtoForPagination> productDtoForPaginationConverter;
    private final PageToPageDtoConverter pageToPageDTOMapper;

    @Override
    public ProductDtoUpdate updateProductById(Long id, ProductDtoUpdate productDto) throws CustomException {
        Product productToUpdate = this.findProduct(id);
        if(productRepository.findProductByName(productDto.getName()).isPresent()) {
            throw new CustomException("Name already exists", HttpStatus.BAD_REQUEST, "/products");
        }
        this.updateOldProduct(productToUpdate, productDto);
        return productDtoUpdateDeleteConverter.toDto(productRepository.save(productToUpdate));
    }

    @Override
    @Transactional
    public ProductDtoCreateProductResponse saveProduct(ProductDtoCreateInput productDtoCreateInput) {
        if (this.findProductByName(productDtoCreateInput.getName())) {
            throw new CustomException("Name already exists", HttpStatus.BAD_REQUEST, "/products");
        }
        List<Long> categoryIds = productDtoCreateInput.getCategoryIds();
        List<Category> categories = new ArrayList<>();
        for (Long id : categoryIds) {
            Category
                category =
                categoryRepository.findById(id).orElseThrow(
                    () -> new CustomException("Category doesn't exist", HttpStatus.NOT_FOUND, "/categories/" + id));
            categories.add(category);
        }
        Product product = productDtoCreateInputConverter.toEntity(productDtoCreateInput);
        product.setCategories(categories);
        return productResponseConverter.toDto(productRepository.save(product));
    }

    @Override
    public PageDto<ProductDtoForPagination> getProducts(Pageable productPage) {
        Page<Product> page = productRepository.findAll(productPage);
        PageDto<ProductDtoForPagination> newPage = pageToPageDTOMapper.toDto(page.map(resource -> productDtoForPaginationConverter.toDto(resource)));
        return newPage;
    }

    @Override
    public void deleteProductById(Long id) throws CustomException {
        this.findProduct(id);
        productRepository.deleteById(id);
    }

    private void updateOldProduct(Product productToUpdate, ProductDtoUpdate productDto) {
        productToUpdate.setName(productDto.getName());
        productToUpdate.setPrice(productDto.getPrice());
        productToUpdate.setDescription(productDto.getDescription());
        productToUpdate.setAmount(productDto.getAmount());
        productToUpdate.setImgUrl(productDto.getImgUrl());
    }

    private Product findProduct(Long id) {
        return productRepository.findProductById(id).orElseThrow(
            () -> new CustomException(DO_NOT_EXIST_MESSAGE, HttpStatus.NOT_FOUND, "products/" + id));
    }

    private boolean findProductByName(String name) {
        return productRepository.findByName(name).isPresent();
    }
}
