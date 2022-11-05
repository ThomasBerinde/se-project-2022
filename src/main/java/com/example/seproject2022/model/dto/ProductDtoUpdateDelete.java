package com.example.seproject2022.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDtoUpdateDelete {

    private String name;
    private float price;
    private String description;
    private int amount;
    private long imgUrl;
}
