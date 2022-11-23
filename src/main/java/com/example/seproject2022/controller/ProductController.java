package com.example.seproject2022.controller;

import com.example.seproject2022.model.dto.PageDto;
import com.example.seproject2022.model.dto.ProductDtoCreateInput;
import com.example.seproject2022.model.dto.ProductDtoCreateProductResponse;
import com.example.seproject2022.model.dto.ProductDtoForPaginationAndGroupByCategory;
import com.example.seproject2022.model.dto.ProductDtoUpdate;
import com.example.seproject2022.model.dto.PageSettings;
import com.example.seproject2022.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public PageDto<ProductDtoForPaginationAndGroupByCategory> getProductsWithFilters(
        @RequestBody PageSettings pageSettings) {
        Sort productSort = pageSettings.buildSort();
        Pageable productPage = PageRequest.of(pageSettings.getPage(), pageSettings.getElementPerPage(), productSort);
        return productService.getProducts(productPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDtoCreateProductResponse> getProductById(@PathVariable("id") Long id,
                                                                HttpServletRequest request) {
        return new ResponseEntity<>(productService.getProductById(id, request.getRequestURI()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDtoUpdate> updateProduct(@PathVariable("id") Long id,
                                                          @RequestBody ProductDtoUpdate productDto,
                                                          HttpServletRequest request) {
        return new ResponseEntity<>(productService.updateProductById(id, productDto, request.getRequestURI()),
                                    HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id, HttpServletRequest request) {
        productService.deleteProductById(id, request.getRequestURI());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductDtoCreateProductResponse> createProduct(
        @RequestBody ProductDtoCreateInput productDto) {
        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.OK);
    }
}
