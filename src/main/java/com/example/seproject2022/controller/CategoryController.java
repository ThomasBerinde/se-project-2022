package com.example.seproject2022.controller;

import com.example.seproject2022.model.dto.CategoryDto;
import com.example.seproject2022.model.dto.ProductDtoForPaginationAndGroupByCategory;
import com.example.seproject2022.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductDtoForPaginationAndGroupByCategory>> listAllProductsByCategory(
        @PathVariable("id") Long id) {
        return new ResponseEntity<>(categoryService.findProductsByCategory(id), HttpStatus.OK);
    }
}
