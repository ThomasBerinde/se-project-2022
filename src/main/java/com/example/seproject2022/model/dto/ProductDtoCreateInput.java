package com.example.seproject2022.model.dto;

import com.example.seproject2022.model.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductDtoCreateInput {

    private String name;
    private float price;
    private String description;
    private int amount;
    private long imgUrl;
    private List<Long> categoryIds = new ArrayList<>();
}
