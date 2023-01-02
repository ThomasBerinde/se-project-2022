package com.example.seproject2022.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.seproject2022.model.dto.CategoryDto;
import com.example.seproject2022.model.dto.ProductDtoForPaginationAndGroupByCategory;
import com.example.seproject2022.model.entity.Category;
import com.example.seproject2022.model.entity.Product;
import com.example.seproject2022.repository.CategoryRepository;
import com.example.seproject2022.repository.ProductRepository;
import com.example.seproject2022.service.converter.Converter;
import com.example.seproject2022.service.impl.CategoryServiceImpl;
import com.example.seproject2022.util.CategoryListBuilder;
import com.example.seproject2022.util.CategoryListDtoBuilder;
import com.example.seproject2022.util.ProductListBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private Converter<Product, ProductDtoForPaginationAndGroupByCategory> productForPaginationAndGroupByCategoryConverter;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private Converter<Category, CategoryDto> categoryConverter;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void shouldFindAllCategories()  {
        //given
        List<Category> expectedCategoryList = CategoryListBuilder.create().build();
        List<CategoryDto> expectedCategoryDtoList = CategoryListDtoBuilder.categoriesDto(expectedCategoryList).build();

        //when
        when(categoryRepository.findAll()).thenReturn(expectedCategoryList);
        int categoryIndex = 0;
        for(Category category : expectedCategoryList) {
            when(categoryConverter.toDto(category)).thenReturn(expectedCategoryDtoList.get(categoryIndex));
            ++categoryIndex;
        }
        List<CategoryDto> categoryDtoList = categoryService.findAll();

        //then
        assertEquals(expectedCategoryDtoList, categoryDtoList);
    }

    @Test
    public void shouldFindProductsByCategory() {
        //given
        Long id = 1L;
        List<Product> expectedAllProducts = ProductListBuilder.create(id).build();
        List <ProductDtoForPaginationAndGroupByCategory> expectedProducts = ProductListBuilder.create(id).buildExpected();

        //when
        when(productRepository.findAll()).thenReturn(expectedAllProducts);
        int index = 0;
        for(Product product : expectedAllProducts) {
            List<Category> categories = product.getCategories();
            for(Category category : categories) {
                if(id.equals(category.getId())) {
                    when(productForPaginationAndGroupByCategoryConverter.toDto(product)).thenReturn(expectedProducts.get(index));
                    ++index;
                    break;
                }
            }
        }
        List <ProductDtoForPaginationAndGroupByCategory> result = categoryService.findProductsByCategory(id);

        //then
        assertEquals(expectedProducts, result);
    }
}
