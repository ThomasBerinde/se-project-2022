package com.example.seproject2022.service;

import com.example.seproject2022.model.dto.PageDto;
import com.example.seproject2022.model.dto.ProductDtoCreateInput;
import com.example.seproject2022.model.dto.ProductDtoCreateProductResponse;
import com.example.seproject2022.model.dto.ProductDtoForPagination;
import com.example.seproject2022.model.dto.ProductDtoUpdate;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    void deleteProductById(Long id);

    ProductDtoUpdate updateProductById(Long id, ProductDtoUpdate productDto);

    ProductDtoCreateProductResponse saveProduct(ProductDtoCreateInput productDto);

    PageDto<ProductDtoForPagination> getProducts(Pageable productPage);
}
