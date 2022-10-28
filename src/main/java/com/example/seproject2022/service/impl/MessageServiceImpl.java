package com.example.seproject2022.service.impl;

import com.example.seproject2022.controller.model.MessageDto;
import com.example.seproject2022.persistance.entity.Message;
import com.example.seproject2022.persistance.repository.MessageRepository;
import com.example.seproject2022.service.MessageService;
import com.example.seproject2022.service.converter.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private Converter<Message, MessageDto> messageConverter;

    @Override
    public MessageDto save(MessageDto messageDto) {
        return messageConverter.toDto(messageRepository.save(messageConverter.toEntity(messageDto)));
    }
}
