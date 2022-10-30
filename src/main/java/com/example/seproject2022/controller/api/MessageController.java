package com.example.seproject2022.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello-world")
@RequiredArgsConstructor
public class MessageController {

    @GetMapping
    public String getMessage() {
        return "hello world";
    }
}
