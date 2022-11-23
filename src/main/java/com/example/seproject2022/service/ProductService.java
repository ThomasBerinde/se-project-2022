package com.example.seproject2022.service;

import com.example.seproject2022.model.dto.PageDto;
import com.example.seproject2022.model.dto.ProductDtoCreateInput;
import com.example.seproject2022.model.dto.ProductDtoCreateProductResponse;
import com.example.seproject2022.model.dto.ProductDtoForPaginationAndGroupByCategory;
import com.example.seproject2022.model.dto.ProductDtoUpdate;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    void deleteProductById(Long id, String requestURI);

    ProductDtoUpdate updateProductById(Long id, ProductDtoUpdate productDto, String requestURI);

    ProductDtoCreateProductResponse saveProduct(ProductDtoCreateInput productDto);

    PageDto<ProductDtoForPaginationAndGroupByCategory> getProducts(Pageable productPage);
}
