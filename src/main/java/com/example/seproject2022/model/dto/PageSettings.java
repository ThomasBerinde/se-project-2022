package com.example.seproject2022.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageSettings {

    private int page = 1;
    private int elementPerPage = 2;
    private String direction = "dsc";
    private String key = "price";

    public Sort buildSort() {
        return switch (direction) {
            case "dsc" -> Sort.by(key).descending();
            case "asc" -> Sort.by(key).ascending();
            default -> Sort.by(key).descending();
        };
    }
}