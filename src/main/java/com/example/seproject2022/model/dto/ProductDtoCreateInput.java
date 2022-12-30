package com.example.seproject2022.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDtoCreateInput {

    private static final String INVALID_PRICE = "The price must be positive";
    private static final String INVALID_AMOUNT = "The amount must be positive";

    @NotNull(message = "email cannot be null or empty")
    private String name;

    @Positive(message = INVALID_PRICE)
    private float price;

    private String description;

    @Positive(message = INVALID_AMOUNT)
    private int amount;

    private String imgUrl;

    @NotNull(message = "List of category ids cannot be null or empty")
    private List<Long> categoryIds = new ArrayList<>();
}
