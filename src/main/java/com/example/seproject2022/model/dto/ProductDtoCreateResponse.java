package com.example.seproject2022.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductDtoCreateResponse {

    private long id;
    private String name;
    private float price;
    private String description;
    private int amount;
    private long imgUrl;
    private List<Long> categoryIds = new ArrayList<>();
}
