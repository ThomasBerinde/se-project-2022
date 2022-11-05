package com.example.seproject2022.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDtoCreateInput {

    private String name;
    private float price;
    private String description;
    private int amount;
    private String imgUrl;
    private List<Long> categoryIds = new ArrayList<>();
}
