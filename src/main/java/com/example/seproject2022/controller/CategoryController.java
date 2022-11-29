package com.example.seproject2022.controller;

import com.example.seproject2022.model.dto.CategoryDto;
import com.example.seproject2022.model.dto.PageSettings;
import com.example.seproject2022.model.dto.ProductDtoForPaginationAndGroupByCategory;
import com.example.seproject2022.service.CategoryService;
import com.example.seproject2022.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ValidatorService validatorService;

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> getAllCategories(@RequestHeader(value = "jwt", required = false) String role,
                                                              HttpServletRequest request) {
        validatorService.validateIsAdmin(role, request.getRequestURI());
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductDtoForPaginationAndGroupByCategory>> listAllProductsByCategory(@PathVariable("id") Long id,
                                                                                                     @RequestHeader(value = "jwt", required = false) String role,
                                                                                                     HttpServletRequest request) {
        validatorService.validateIsUser(role, request.getRequestURI());
        return new ResponseEntity<>(categoryService.findProductsByCategory(id), HttpStatus.OK);
    }
}
