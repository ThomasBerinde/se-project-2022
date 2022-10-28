package com.example.seproject2022.controller.api;

import com.example.seproject2022.controller.model.MessageDto;
import com.example.seproject2022.persistance.entity.Message;
import com.example.seproject2022.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello-world")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping
    public String getMessage() {
        return "hello world";
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@RequestBody MessageDto messageDto) {
        return new ResponseEntity<>(messageService.save(messageDto), HttpStatus.CREATED);
    }
}
