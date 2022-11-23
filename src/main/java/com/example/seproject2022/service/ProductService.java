package com.example.seproject2022.service;

import com.example.seproject2022.model.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    void deleteProductById(Long id);

    ProductDtoUpdateDelete updateProductById(Long id, ProductDtoUpdateDelete productDto);

    ProductDtoCreateResponse saveProduct(ProductDtoCreateInput productDto);

    PageDto<ProductDtoForPagination> getProducts(Pageable productPage);
}
