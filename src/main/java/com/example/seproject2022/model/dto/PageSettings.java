package com.example.seproject2022.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageSettings {

    private static final String INVALID_PAGE = "The page must be positive";
    private static final String INVALID_ELEMENTS_PER_PAGE = "The no of elements per page must be positive";

    @Positive(message = INVALID_PAGE)
    private int page;

    @Positive(message = INVALID_ELEMENTS_PER_PAGE)
    private int elementPerPage;

    @Pattern(regexp = "^(dsc|asc)$", message = "Invalid direction, it can be just dsc or asc")
    private String direction;

    @Pattern(regexp = "^(name|price|amount)$", message = "You can sort just by name, price or amount")
    private String key;

    public Sort buildSort() {
        return switch (direction) {
            case "dsc" -> Sort.by(key).descending();
            case "asc" -> Sort.by(key).ascending();
            default -> Sort.by(key).descending();
        };
    }
}