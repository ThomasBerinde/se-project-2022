package com.example.seproject2022.service.converter;

import com.example.seproject2022.controller.model.MessageDto;
import com.example.seproject2022.persistance.entity.Message;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageConverter implements Converter<Message, MessageDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Message toEntity(MessageDto messageDto) {
        return modelMapper.map(messageDto, Message.class);
    }

    @Override
    public MessageDto toDto(Message message) {
        return modelMapper.map(message, MessageDto.class);
    }
}
