package com.example.seproject2022.util;

import static com.example.seproject2022.model.entity.CategoryName.ELECTRONICS;

import com.example.seproject2022.model.dto.ProductDtoForPaginationAndGroupByCategory;
import com.example.seproject2022.model.entity.Category;
import com.example.seproject2022.model.entity.CategoryName;
import com.example.seproject2022.model.entity.Product;
import net.bytebuddy.utility.RandomString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductListBuilder {

    private final List<Product> products;
    private final List<ProductDtoForPaginationAndGroupByCategory> productDtoForPaginationAndGroupByCategory;

    public ProductListBuilder() {
        this.products = new ArrayList<>();
        this.productDtoForPaginationAndGroupByCategory = new ArrayList<>();
    }

    public List<Product> build() {
        return products;
    }

    public List<ProductDtoForPaginationAndGroupByCategory> buildExpected() {
        return productDtoForPaginationAndGroupByCategory;
    }

    public static ProductListBuilder defaultValues() {
        return new ProductListBuilder();
    }

    public static ProductListBuilder create(Long id) {
        ProductListBuilder productListBuilder = defaultValues();
        productListBuilder.setProducts();
        productListBuilder.setProductsGroupByCategory(id);
        return productListBuilder;
    }

    public ProductListBuilder setProducts() {
        this.products.add(createNewProduct());
        this.products.add(createNewProduct());
        return this;
    }
    public ProductListBuilder setProductsGroupByCategory(Long id) {
        for(Product product : products) {
            List<Category> categories = product.getCategories();
            for(Category category : categories) {
                if (id.equals(category.getId())) {
                    this.productDtoForPaginationAndGroupByCategory.add(toDto(product));
                }
            }
        }
        return this;
    }

    public Product createNewProduct() {
        Random random = new Random();
        RandomString randomString = new RandomString(10);
        Product newProduct = new Product();
        newProduct.setImgUrl("...");
        newProduct.setAmount(Math.abs(random.nextInt(100)));
        newProduct.setName(randomString.nextString());
        newProduct.setPrice((float) (10.3 + Math.abs(random.nextInt(1000))));
        newProduct.setCategories(List.of(createNewCategory(ELECTRONICS)));
        return newProduct;
    }

    private Category createNewCategory(CategoryName categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        category.setId(1);
        return category;
    }

    private ProductDtoForPaginationAndGroupByCategory toDto(Product product) {
        ProductDtoForPaginationAndGroupByCategory prod = new ProductDtoForPaginationAndGroupByCategory();
        prod.setAmount(product.getAmount());
        prod.setPrice(product.getPrice());
        prod.setName(product.getName());
        prod.setId(product.getId());
        prod.setImgUrl(product.getImgUrl());
        prod.setDescription(product.getDescription());
        return prod;
    }
}
