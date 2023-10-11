package com.sku.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final RestTemplate restTemplate;

    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }

    @PostMapping("/auth")
    public String getAuthResult(String username, String password) {
        System.out.println(restTemplate.exchange("http://board/test", HttpMethod.POST, null, String.class, username, password).getBody());
        return "";
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        System.out.println("MainController.test()");
        return "test";
    }
}