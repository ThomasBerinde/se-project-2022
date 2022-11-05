package com.example.seproject2022.model.entity;
import org.springframework.data.domain.Sort;
import lombok.Data;

@Data
public class PageSettings {

    private int page = 0;

    private int elementPerPage = 2;

    private String direction = "dsc";

    private String key;

    public Sort buildSort() {
        return switch (direction) {
            case "dsc" -> Sort.by(key).descending();
            case "asc" -> Sort.by(key).ascending();
            default -> Sort.by(key).descending();
        };
    }
}