package com.sku.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final RestTemplate restTemplate;

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
