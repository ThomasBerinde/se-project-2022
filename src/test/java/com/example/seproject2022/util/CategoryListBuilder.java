package com.example.seproject2022.util;

import static com.example.seproject2022.model.entity.CategoryName.ELECTRONICS;
import static com.example.seproject2022.model.entity.CategoryName.FASHION;
import static com.example.seproject2022.model.entity.CategoryName.FOOD;
import static com.example.seproject2022.model.entity.CategoryName.HOME_USE;

import com.example.seproject2022.model.entity.Category;
import com.example.seproject2022.model.entity.CategoryName;

import java.util.ArrayList;
import java.util.List;

public class CategoryListBuilder {

    private final List<Category> categories;

    public CategoryListBuilder() {
        this.categories = new ArrayList<>();
    }

    public List<Category> build() {
        return categories;
    }

    public static CategoryListBuilder defaultValues() {
        return new CategoryListBuilder();
    }

    public static CategoryListBuilder create() {
        CategoryListBuilder categoryListBuilder = defaultValues();
        categoryListBuilder.setListCategories();
        return categoryListBuilder;
    }

    public CategoryListBuilder setListCategories() {
        this.categories.add(createNewCategory(ELECTRONICS));
        this.categories.add(createNewCategory(FASHION));
        this.categories.add(createNewCategory(FOOD));
        this.categories.add(createNewCategory(HOME_USE));
        return this;
    }

    private Category createNewCategory(CategoryName categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        return category;
    }
}
