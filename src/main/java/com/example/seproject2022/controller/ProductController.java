package com.example.seproject2022.controller;

import com.example.seproject2022.model.dto.*;
import com.example.seproject2022.model.entity.PageSettings;
import com.example.seproject2022.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public PageDto<ProductDtoForPagination> getProductsWithFilters(PageSettings pageSettings) {
        Sort productSort = pageSettings.buildSort();
        Pageable productPage = PageRequest.of(pageSettings.getPage(), pageSettings.getElementPerPage(), productSort);
        return productService.getProducts(productPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDtoUpdateDelete> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDtoUpdateDelete productDto) {
        return new ResponseEntity<>(productService.updateProductById(id, productDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductDtoCreateResponse> createProduct(@RequestBody ProductDtoCreateInput productDto) {
        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.OK);
    }
}
