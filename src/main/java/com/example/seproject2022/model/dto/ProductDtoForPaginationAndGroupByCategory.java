package com.example.seproject2022.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDtoForPaginationAndGroupByCategory {

    private long id;
    private String name;
    private float price;
    private String description;
    private int amount;
    private String imgUrl;
}
