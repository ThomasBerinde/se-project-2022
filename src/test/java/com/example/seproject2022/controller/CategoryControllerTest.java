package com.example.seproject2022.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.seproject2022.model.dto.CategoryDto;
import com.example.seproject2022.model.dto.ProductDtoForPaginationAndGroupByCategory;
import com.example.seproject2022.model.entity.Category;
import com.example.seproject2022.service.CategoryService;
import com.example.seproject2022.service.ValidatorService;
import com.example.seproject2022.util.CategoryListBuilder;
import com.example.seproject2022.util.CategoryListDtoBuilder;
import com.example.seproject2022.util.ProductListBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @Mock
    private ValidatorService validatorService;

    @InjectMocks
    private CategoryController categoryController;

    @Test
    public void shouldGetAllCategories() {
        //given
        HttpServletRequest request = mock(HttpServletRequest.class);
        List<Category> expectedCategoryList = CategoryListBuilder.create().build();
        List<CategoryDto> expectedCategoryDtoList = CategoryListDtoBuilder.categoriesDto(expectedCategoryList).build();

        //when
        when(categoryService.findAll()).thenReturn(expectedCategoryDtoList);
        ResponseEntity<List<CategoryDto>> result = categoryController.getAllCategories(request);

        //then
        assertEquals(expectedCategoryDtoList, result.getBody());
    }

    @Test
    public void shouldListAllProductsByCategory() {
        //given
        Long id = 1L;
        HttpServletRequest request = mock(HttpServletRequest.class);
        List <ProductDtoForPaginationAndGroupByCategory> expectedProducts = ProductListBuilder.create(id).buildExpected();

        //when
        when(categoryService.findProductsByCategory(id)).thenReturn(expectedProducts);
        ResponseEntity<List<ProductDtoForPaginationAndGroupByCategory>> result = categoryController.listAllProductsByCategory(id, "VVNFUg==", request);

        //then
        assertEquals(expectedProducts, result.getBody());
    }
}
