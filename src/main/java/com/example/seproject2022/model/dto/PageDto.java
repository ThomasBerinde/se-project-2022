package com.example.seproject2022.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDto<T> {

    public PageDto(Page<T> page) {
        this.content = page.getContent();
    }

    private List<T> content;
}