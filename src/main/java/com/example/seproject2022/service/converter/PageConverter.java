package com.example.seproject2022.service.converter;

import com.example.seproject2022.model.dto.PageDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PageConverter<T> {

    public PageDto<T> pageToPageDTO(Page<T> page) {
        PageDto<T> pageDTO = new PageDto<>();
        pageDTO.setContent(page.getContent());
        pageDTO.setTotalElements(page.getTotalElements());

        return pageDTO;
    }
}